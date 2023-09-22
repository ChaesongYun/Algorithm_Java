import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2805 {
	static int arr[];
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 1; int end = arr[arr.length-1];
		while(start <= end) {
			int mid = (start + end) / 2;
			if(check(mid)) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}
	
	static boolean check(int cuttingHeight) {
		long sum = 0;
		long temp; 
		long tree;
		boolean check = false;
		for(int i = 0; i < arr.length; i++) {
			tree = arr[i];
			if(tree >= cuttingHeight) {
				temp = tree - cuttingHeight;
				sum += temp;
			}
		}
		if(sum >= M) check = true;
		return check;
	}
}
