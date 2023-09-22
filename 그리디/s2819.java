import java.util.*;
import java.io.*;

public class s2819 {
	static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static String arr[][];
	static int cnt;
	static HashSet<String> hs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			arr = new String[4][4];
			for(int i = 0; i < 4; i++) {
				String line[] = br.readLine().split(" ");
				arr[i] = line; 	
			}
			cnt = 0;
			hs = new HashSet<>();
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					char now[] = new char[7];
					now[0] = arr[i][j].charAt(0);
					sevenNum(1, i, j, now);		
				}
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void sevenNum(int depth, int stx, int sty, char now[]) {
		if(depth >= 7) {
			if(!hs.contains(String.valueOf(now))) {
				cnt++;
				hs.add(String.valueOf(now));
			}
			return;
		}
		for(int k = 0; k < 4; k++) {
			int nx = stx + dir[k][0];
			int ny = sty + dir[k][1];
			if(0 <= nx && nx < 4 && 0 <= ny && ny < 4) {
				now[depth] = arr[nx][ny].charAt(0);
				sevenNum(depth+1, nx, ny, now);
			}
		}
	}
}
