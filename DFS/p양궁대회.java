import java.util.*;

class Solution {
    static private int[] res = new int[11];
    static private int[] lion;
    static private int max = Integer.MIN_VALUE;
    public static int[] solution(int n, int[] info){
        dfs(0, n, info);
        if(max == -1){
            lion = new int[]{-1};
        }
        return lion;     
    }
    
    public static void dfs(int depth, int n, int[] info){
        // 화살 다 꽂았다면
        if(depth == n){
            int diff = score(info);
            if(max <= diff){
                max = diff;
                lion = res.clone();
            }
            return;
        }
        
        for(int i = 0; i < info.length && res[i] <= info[i]; i++){
            res[i] += 1;
            dfs(depth+1, n, info);
            res[i] -= 1;
        }
    }
    
    // 점수 차이 계산
    public static int score(int[] info){
        int apeach = 0; int lion = 0;
        for(int i = 0; i < res.length; i++){
            if(info[i] == 0 && res[i] == 0) continue;
            if(info[i] >= res[i]) {
                apeach += (10-i);
            }else{
                lion += (10-i);
            }
        }
        
        int diff = lion - apeach;
        if(diff <= 0) return -1;
        return diff;
    }
}
