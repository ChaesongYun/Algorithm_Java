import java.util.*;
import java.io.*;

public class b2437 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long sum = 0;
		for(int i = 0; i < N; i++) {
			if(sum + 1 < arr[i]) {
				break;
			}
			sum += arr[i];
		}
		System.out.println(sum+1);
	}
}
