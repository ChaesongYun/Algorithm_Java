import java.util.*;

class Solution {
    static HashMap<String, List<Integer>> hm;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        hm = new HashMap<String, List<Integer>>();
        
        for(int i = 0; i < info.length; i++){
            String[] p = info[i].split(" "); //[java, backend, junior, pizza, 150]
            makeSentence(p, "", 0);
        }
        
        for(String key: hm.keySet()){
            // hm.get(key) => "pythonfrontendseniorchicken" : [210, 150]
            Collections.sort(hm.get(key));
        }
        
        for(int i = 0; i < query.length; i++){
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = hm.containsKey(q[0])? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
        return answer;
    }
    
    private static int binarySearch(String key, int score){
        List<Integer> list = hm.get(key);
        int start = 0; int end = list.size() - 1;
        
        while(start <= end){
            int mid = (start+end) / 2;
            if(list.get(mid) < score) start = mid+1;
            else end = mid-1;
        }
        
        return list.size() - start;
    }
    
    private static void makeSentence(String[] p, String str, int cnt){
        if(cnt == 4){
            if(!hm.containsKey(str)){
                List<Integer> list = new ArrayList<Integer>();
                hm.put(str, list);
            }
            hm.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        makeSentence(p, str+"-", cnt+1);
        makeSentence(p, str+p[cnt], cnt+1);
    }
}
