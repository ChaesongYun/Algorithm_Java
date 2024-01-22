package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b1700 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[k];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for(int i = 0; i < k; i++){
            int num = list.get(i);
            // 사용하고 있는 기기라면
            if(set.contains(num)) continue;
            // 꽂을 공간이 있다면
            if(set.size() < n){
                set.add(num);
                continue;
            }
            // 사용하는 기기도 아니고, 꽂을 공간도 없을 때
            int max = -1, idx = -1;
            for(int s: set){
                int temp = 0;
                // 나 이후에 사용될 기기들
                List<Integer> sub = list.subList(i+1, k);
                // 나중에도 사용될 기기라면
                if(sub.contains(s)){
                    temp = sub.indexOf(s);
                }
                // 사용되지 않는 기기라면-> 뒤로 밀어버리기
                else{
                    temp = k;
                }
                // temp가 작을수록 가장 빨리 사용될 기기라는 뜻
                // 즉, temp가 가장 큰 값을 빼버려야 함
                if(temp > max){
                    max = temp;
                    idx = s;
                }
            }
            // 가장 나중에 사용되는 기기를 빼고 그 자리에 꽂는다
            set.remove(idx);
            set.add(num);
            cnt++;
        }
        System.out.println(cnt);
    }
}
