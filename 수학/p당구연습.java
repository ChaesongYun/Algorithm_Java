import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i = 0; i < balls.length; i++){
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int curLen, len = Integer.MAX_VALUE;
            
            if(!(startY == targetY && startX >= targetX)){
                curLen = dist(startX, startY, targetX*(-1), targetY);
                len = Math.min(len, curLen);
            }
            if(!(startY == targetY && startX <= targetX)){
                curLen = dist(startX, startY, m+(m-targetX), targetY);
                len = Math.min(len, curLen);
            }
            if(!(startX == targetX && startY <= targetY)){
                curLen = dist(startX, startY, targetX, n+(n-targetY));
                len = Math.min(len, curLen);
            }
            if(!(startX == targetX && startY >= targetY)){
                curLen = dist(startX, startY, targetX, targetY*(-1));
                len = Math.min(len, curLen);
            }
            answer[i] = len;
        }   
        return answer;
    }
    static int dist(double x1, double y1, double x2, double y2){
        return (int)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}
