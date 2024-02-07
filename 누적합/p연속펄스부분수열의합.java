import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int a = 1, b = -1, size = sequence.length;
        long aSum = sequence[0];
        long bSum = sequence[0] * b;
        long aMin = 0, bMin = 0;
        long max = Long.MIN_VALUE;
        
        for(int i = 0; i <= size; i++){
            a *= -1;
            b *= -1;
            
            max = Math.max(max, aSum-aMin);
            max = Math.max(max, bSum-bMin);
            aMin = Math.min(aMin, aSum);
            bMin = Math.min(bMin, bSum);

            if (i == size) break;
            
            aSum += sequence[i] * a;
            bSum += sequence[i] * b;
        }
        
        return max;
    }
}
