import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1781 {
	static int N;
	static PriorityQueue<Integer> quests;
	static ArrayList<Work> arr; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		quests = new PriorityQueue<>();
		arr = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(arr);
		int ans = 0;
		for(Work work : arr) {
			int size = quests.size(); //내가 과제를 해서 진행된 시간
			//할 과제를 quests에 넣는거니까
			if(size < work.dead) {
				quests.add(work.cup); 
			}
			else if(size == work.dead) {
				if(work.cup > quests.peek()) {
					quests.poll();
					quests.add(work.cup);
				}
			}
		}
		while(!quests.isEmpty()) {
			ans += quests.poll();
		}
		System.out.println(ans);
	}
	static class Work implements Comparable<Work>{
		int dead, cup;
		Work(int dead, int cup){
			this.dead = dead;
			this.cup = cup;
		}
		@Override
		public int compareTo(b1781.Work o) {
			// TODO Auto-generated method stub
			if(this.dead == o.dead) { //만약 데드라인이 같다면
				return Integer.compare(o.cup, this.cup); //컵라면 오름차순 정렬
			}
			return Integer.compare(this.dead, o.dead); //데드라인 오름차순 정렬
		} 
	}
}
