public class Solution{
    public int solution(int[] cookie){
        int answer = 0;
        
        for(int i = 0; i < cookie.length-1; i++){
            int left = i;
            int leftSum = cookie[left];
            
            int right = i+1;
            int rightSum = cookie[right];
            
            while(true){
                if(leftSum == rightSum && answer < leftSum){
                    answer = leftSum;
                }else if(leftSum <= rightSum && 0 < left){
                    leftSum += cookie[--left];
                }else if(rightSum <= leftSum && right < cookie.length-1){
                    rightSum += cookie[++right];
                }else{
                    break; 
                }
            }
        }
        
        return answer;
    }
}
