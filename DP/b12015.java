package baekjoon;

import java.util.*;
import java.io.*;

public class b12015 {
    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int dp[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        // LIS 초기값으로 첫번째 수열의 값을 갖는다
        dp[0] = arr[0];
        int length = 0;

        for(int i = 1; i < N; i++) {
            int key = arr[i];

            // 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다
            if(dp[length] < key) {
                length++;
                dp[length] = key;
            }else {
                int l = 0;
                int r = length+1;
                while(l <= r) {
                    int mid = (l+r)/2;
                    if(dp[mid] < key) {
                        l = mid+1;
                    }else {
                        r = mid-1;
                    }
                }
                dp[l] = key;
            }
        }
        System.out.println(length+1);
    }
}

