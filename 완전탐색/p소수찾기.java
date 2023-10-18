import java.util.*;

class Solution {
    static ArrayList<Integer> lst;
    static boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        lst = new ArrayList<>();
        for(int i = 1; i <= numbers.length(); i++){
            dfs(numbers, "", i);
        }
        int ans = 0;
        for(int i = 0; i < lst.size(); i++){
            if(check(lst.get(i))) ans++; 
        }
        return ans;
    }
    // 소수판별
    public boolean check(int n){
        if(n < 2) return false;
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0) return false;
        }   
        return true;
    }
    // 백트래킹
    // 주어진 문자열, 현재 문자열, 뽑아야 할 개수
    public void dfs(String str, String temp, int n){
        if(temp.length() == n){
            int now = Integer.parseInt(temp);
            if(!lst.contains(now)){
                lst.add(now);
            }
            return;
        }
        for(int i = 0; i < str.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                temp += str.charAt(i);
                dfs(str, temp, n);
                visited[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
    }
}

// 소수 판별 알고리즘 짤 때
// 2보다 작은 건 다 false로 return 해줘야한다..!!!
