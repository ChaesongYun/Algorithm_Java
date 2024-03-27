import java.util.*;

class Solution {
        public int solution(int[][] scores) {
            int[] wanHo = scores[0];

            // 근무태도점수 내림차순정렬. 근무태도 동점인 경우 동료평가점수 오름차순
            Arrays.sort(scores, (a, b) -> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);

            int answer = 1, maxScore = 0, wanHoSum = wanHo[0] + wanHo[1];

            for(int[] score : scores) {
                if(score[1] < maxScore) {
                    if(score.equals(wanHo)) return -1;
                }else{
                    maxScore = Math.max(maxScore, score[1]);
                    if(score[0] + score[1] > wanHoSum) answer++;
                }
            }

            return answer;
        }
}
