import java.util.*;

class Solution {
    public int solution(int[] money) {
        int ans = 0;
        int n = money.length;
        if(n == 3){
            Arrays.sort(money);
            return money[2];
        }
        //첫번째 집 터는 경우 => 마지막 집은 털면 안됨
        int dp1[] = new int[n];
        //첫번째 집 안터는 경우 
        int dp2[] = new int[n];
        
        dp1[0] = money[0];
        dp1[1] = Math.max(dp1[0], money[1]);
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
        
        for(int i = 2; i < n; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
            ans = Math.max(dp2[i], ans);
            
            if(i == n-1) break;
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+money[i]);
            ans = Math.max(dp1[i], ans);
            
        }
    
        return ans;
    }
}
