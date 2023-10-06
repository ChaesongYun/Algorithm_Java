// 이걸 어떻게 푸냐면..
// GCF
// ACDEB
// 이렇게 있을 때
// A는 10000의 자리
// C는 1000의 자리
// D는 100의 자리
// E는 10의 자리
// B는 1의 자리...
// -> 그럼 GCF + ACDEB는 = 10000A + B + 1010C + 100D + 10E + 100G + F이렇게 되니까
// -> int[26] 배열을 만들어서 각각의 알파벳에 해당하는 인덱스에 숫자를 넣어주면 됨


import java.util.*;
import java.io.*;

public class b1339 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		int alpha[] = new int[26];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		
		for(int i = 0; i < n; i++) {
			int temp = (int)Math.pow(10, arr[i].length()-1);
			for(int j = 0; j < arr[i].length(); j++) {
				alpha[(int)arr[i].charAt(j) - 65] += temp;
				temp /= 10;
			}
		}
		
		Arrays.sort(alpha);
		int idx = 9;
		int sum = 0;
		for(int i = alpha.length-1; i >= 0; i--) {
			if(alpha[i] == 0) break;
			sum += alpha[i]*idx;
			idx--;
		}
		System.out.println(sum);
	}
}
