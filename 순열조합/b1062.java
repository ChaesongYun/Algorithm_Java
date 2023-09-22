import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N, K, ans;
	static boolean visit[];
	static String arr[];
	static ArrayList<Integer> temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		arr = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().replaceAll("anta|tical", "");
		}
		if(K < 5) {
			System.out.println(0);
			return;
		}else if(K == 26) {
			System.out.println(N);
			return;
		}
		ans = 0;
		visit = new boolean[26];
		visit['a' - 97] = true; 
		visit['n' - 97] = true; 
		visit['t' - 97] = true; 
		visit['i' - 97] = true; 
		visit['c' - 97] = true;
		dfs(0, 0);
		System.out.println(ans);
	}
	static void dfs(int stx, int r) {
		if(r == K-5) {
			able();
			return;
		}
		for(int i = stx+1; i < 26; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, r+1);
				visit[i] = false;	
			}
		}	
	}
	static void able() {
		int now = 0;
		boolean check;
		for(String s : arr) {
			check = true;
			for(int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				if(!visit[temp-97]) {
					check = false;
					break;
				}
			}
			if(check) now++;
		}
		ans = Math.max(now, ans);			
	}
}
