import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        
        for(Long i = left; i <= right; i++){
            int y = (int)(i/n);
            int x = (int)(i%n);
            int value = Math.max(y, x)+1;
            list.add(value);
        }
        
        return list.stream().mapToInt(i-> i).toArray();
    }
}
