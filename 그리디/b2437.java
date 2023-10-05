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

/*
오름차순으로 수들이 정렬되어 있다면 
누적합+1 < 다음수
라면 누적합+1은 만들 수 없는 수이다
*/
