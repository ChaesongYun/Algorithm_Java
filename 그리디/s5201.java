import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Integer cargo[] = new Integer[N];
            for(int i = 0; i < N; i++) {
                cargo[i] = sc.nextInt();
            }
            Arrays.sort(cargo, Collections.reverseOrder());
            Integer capacity[] = new Integer[M];
            for(int i = 0; i < M; i++) {
                capacity[i] = sc.nextInt();
            }
            Arrays.sort(capacity, Collections.reverseOrder());
            int left = 0; int ans = 0;
            for(int tr : capacity) {
                while(left < N && tr < cargo[left]) {
                    left++;
                }
                if(left == N) break;
                ans += cargo[left];
                left++;
            }
            System.out.println("#"+t+" "+ans);
        }
    }
}
