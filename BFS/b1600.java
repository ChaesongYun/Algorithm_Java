import java.util.*;
import java.io.*;

public class b1600 {
	// 순서대로 위, 오른쪽, 아래, 왼쪽
	static int[][] monkey = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] horse = {{-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, 
							{2, 1}, {2, -1}, {1, -2}, {-1, -2}};
	
	static int[][] arr;
	static int[][][] visited;
	static int K, W, H, ans;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][W];
		visited = new int[K+1][H][W];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		bfs();
		
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		
		System.out.println(ans);
	}
	
	static class Node{
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", k=" + k + "]";
		}
		int x, y, k;
		Node(int x, int y, int k){
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
	
		q.add(new Node(0, 0, K));
		visited[K][0][0] = 1;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int k = temp.k;
			int depth = visited[k][x][y]; 
					
			// 도착했다면 
			if(x == H-1 && y == W-1) {
				ans = Math.min(ans, depth-1);
			}
			
			// 횟수가 남아있다면 말, 원숭이 둘다 행동ㄱㄴ
			if(k > 0) {
				move("horse", x, y, k, depth, q);
				move("monkey", x, y, k, depth, q);
			}else {
				move("monkey", x, y, k, depth, q);
			}
		}
	}
	
	// 범위 안에 존재?
	static boolean check(int x, int y, int k) {
		return 0 <= x && x < H && 0 <= y && y < W && visited[k][x][y] == 0 && arr[x][y] == 0;
	}

	// 어떤 동물처럼 움직일지?
	static void move(String animal, int x, int y, int k, int depth, Queue<Node> q) {
		if(animal.equals("horse")) {
			for(int i = 0; i < 8; i++) {
				int nx = x + horse[i][0];
				int ny = y + horse[i][1];
				if(check(nx, ny, k-1)) {
					q.add(new Node(nx, ny, k-1));
					visited[k-1][nx][ny] = depth+1;
				}
			}
		}else {
			for(int i = 0; i < 4; i++) {
				int nx = x + monkey[i][0];
				int ny = y + monkey[i][1];
				if(check(nx, ny, k)) {
					q.add(new Node(nx, ny, k));
					visited[k][nx][ny] = depth+1;
				}
			}
		}
	}
}
