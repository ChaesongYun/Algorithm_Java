import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        // x=i일때 minJ는 안쪽 원 위에 있는 y좌표 중 가장 가까운 정수
        // maxJ는 바깥 원 위에 있는 y좌표 중 가장 안쪽의 정수
        for(int i = 1; i <= r2; i++){
            long minJ = (int)Math.ceil(Math.sqrt(1.0*r1*r1-1.0*i*i));
            long maxJ = (int)Math.floor(Math.sqrt(1.0*r2*r2-1.0*i*i));
            answer += (maxJ - minJ + 1);
        }
        return answer*4;
    }
}
