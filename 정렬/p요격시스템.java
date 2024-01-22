import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets,(o1,o2)-> {
            return o1[1]-o2[1]; 
        });


        int x = 0;

        for(int i=0;i<targets.length;i++){
            //System.out.println(targets[i][0]);
            if(x<=targets[i][0]){
                x = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}
