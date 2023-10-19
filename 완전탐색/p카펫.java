import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int multi = brown+yellow;
        int plus = (int)(brown/2)+2;
        
        int w = 1;
        int h = 1;
        for(int i = 1; i <= multi; i++){
            if(multi%i == 0 && i+(int)(multi/i) == plus){
                w = Math.max(i, (int)(multi/i));
                h = Math.min(i, (int)(multi/i));
                break;
            }
        }
        
        int[] answer = {w, h};

        return answer;

    }

}
