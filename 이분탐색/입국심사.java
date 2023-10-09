import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = 0;
        long r = (long) times[times.length-1] * n; // 최대로 걸리는 시간
        System.out.println(r);
        long answer = 0; 
        while(l <= r){
            long now = 0;
            long mid = (l+r) / 2;
            for(int i = 0; i < times.length; i++){
                now += mid / times[i];
            }
            if(n <= now){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}

// 숫자가 너무 비상식적으로 크다-> 이분탐색일 가능성 있음
// 그리고 times는 int 배열, n도 int 그러면 둘의 곱도 int형인데
// int 범위 넘어가면 -로 찍힘=> 앞에 (long)으로 형 변환 해줘야함
