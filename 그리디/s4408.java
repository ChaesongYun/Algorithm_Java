import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[N][2];
            int visit[] = new int[201];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); //시작지점
                arr[i][1] = Integer.parseInt(st.nextToken()); //끝지점
            }
            for(int i = 0; i < N; i++) {
                int first = arr[i][0]; int second = arr[i][1];  
                if(first <= second) {
                    for(int j = (first-1)/2; j <= (second-1)/2; j++) {
                        visit[j]++;
                    }                   
                }
                else {
                    for(int j = (second-1)/2; j <= (first-1)/2; j++) {
                        visit[j]++;
                    }
                }
            }
            int max = 0;
            for(int i = 0; i < 201; i++) {
                max = visit[i] > max? visit[i] : max;
            }
            System.out.println("#"+tc+" "+max);
        }
    }
}
