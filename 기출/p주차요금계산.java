import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            // 5961, 0
            // 0000, 0
            feeMap.put(records[i].split(" ")[1], 0);
        }
        
        for(int i = 0; i < records.length; i++){
            // [05:34, 5961, IN]
            String[] infos = records[i].split(" ");         
            // 존재하는 차량 번호라면(입차한 차량이라면)
            if(map.containsKey(infos[1])) {
                String[] inTime = map.remove(infos[1]).split(":");  
                String[] outTime = infos[0].split(":");
                
                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int min = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
                
                feeMap.replace(infos[1], feeMap.get(infos[1]) + 60*hour + min);
            }
            // 이제 입차하는 차량이라면
            else{
                map.put(infos[1], infos[0]);
            }
        }
        
        // 마지막까지 출차하지 않은 차량이라면
        for(String key: map.keySet()){
            String[] inTime = map.get(key).split(":");
            
            int hour = 23 - Integer.parseInt(inTime[0]);
            int min = 59 - Integer.parseInt(inTime[1]);
            
            feeMap.replace(key, feeMap.get(key) + 60*hour + min);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList(feeMap.entrySet());
        Collections.sort(list, (o1, o2)->{
            return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
        });
            
        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            if(list.get(i).getValue() > fees[0]){
                answer[i] = fees[1] + (int)Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                answer[i] = fees[1];
            }
        }
        return answer;
    }
}
