import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int num[] = new int[N];
        int standard[] = new int[5000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }//입력값 받기
        for(int i = 0; i < 5000001; i++){
            standard[i] = i;
        }
        sosu(5000001, standard);
        for(int i = 0; i < N; i++){
            int temp = num[i];
            while (temp > 1){
                //standard[temp]는 temp의 가장 작은 소인수
                sb.append(standard[temp]).append(" ");
                temp /= standard[temp];
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }//main함수 종료
    static void sosu(int n, int A[]){
        int one[] = new int[n];
        for(int i = 0; i < n; i++){
            one[i] = 1;
        }
        one[0] = one[1] = 0;
        for(int i = 2; i*i < n; i++){
            if(one[i] == 1){
                for(int j = i+i; j < n; j += i){
                    one[j] = 0;
                    if (A[j] == j){
                        A[j] = i; //가장 작은 소인수 입력
                    }
                }
            }
        }
    }
}
