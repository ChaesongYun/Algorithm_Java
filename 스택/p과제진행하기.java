import java.util.*;

class Solution {
    public List<String> solution(String[][] plans) {
        // 정답 저장 리스트
        List<String> answer = new ArrayList<>();
        
        // 해야할 과제 시간 순 저장
        PriorityQueue<Quest> pq = new PriorityQueue<>((o1, o2)->{
            return o1.start - o2.start;
        });
        
        for(int i = 0; i < plans.length; i++){
            String now[] = plans[i];
            String sub = now[0];
            int h = Integer.parseInt(now[1].substring(0, 2));
            int m = Integer.parseInt(now[1].substring(3));
            int t = Integer.parseInt(now[2]);
            int s = hour_to_min(h, m);
            pq.add(new Quest(sub, s, t));
        }
        
        Stack<Quest> stack = new Stack<>();
        
        while(!pq.isEmpty()){
            Quest cur = pq.poll();
            String sub = cur.sub;
            int start = cur.start;
            int play = cur.play;
            
            int currentTime = start;
            if(!pq.isEmpty()){
                Quest next = pq.peek();
                // 지금꺼 끝내도 다음 과제까지 시간이 남는다면
                if(currentTime + play < next.start){
                    answer.add(sub);
                    currentTime += play;
                    
                    // 멈춘 과제가 있다면 남는 시간 동안 과제 해결
                    while(!stack.isEmpty()){
                        Quest remain = stack.pop();
                        if(currentTime + remain.play <= next.start){
                            currentTime += remain.play;
                            answer.add(remain.sub);
                            continue;
                        }else{
                            int t = remain.play - (next.start - currentTime);
                            stack.push(new Quest(remain.sub, next.start, t));
                            break;
                        }
                    }
                }else if(currentTime + play == next.start){
                    answer.add(sub);
                }else{
                    int t = next.start - currentTime;
                    stack.push(new Quest(sub, next.start, play-t));
                }
            }
            // 남아있는 과제가 없다면
            else{
                answer.add(sub);
                while(!stack.isEmpty()){
                    answer.add(stack.pop().sub);
                }
            }
        }

        return answer;
    }
    static class Quest{
        String sub;
        int start, play;
        Quest(String sub, int start, int play){
            this.sub = sub;
            this.start = start;
            this.play = play;
        }
    }
    static int hour_to_min(int h, int m){
        return h*60+m;
    }
}
