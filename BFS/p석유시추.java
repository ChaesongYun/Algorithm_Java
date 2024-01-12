import java.util.*;

class Solution {
    private int[] dir_x = {1, 0, -1, 0};
    private int[] dir_y = {0, 1, 0, -1};
    private int w, h, group_idx;
    private boolean[][] visited;
    private int[][] group;
    private HashMap<Integer, Integer> hm;
    public int solution(int[][] land) {
        w = land.length;
        h = land[0].length;
        visited = new boolean[w][h];
        group = new int[w][h];
        hm = new HashMap<>();
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(land, i, j, ++group_idx);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < h; i++){
            HashSet<Integer> hs = new HashSet<>();
            int oil = 0;
            for(int j = 0; j < w; j++){
                if(group[j][i] != 0 && !hs.contains(group[j][i])){
                    hs.add(group[j][i]);        
                }
            }
            Iterator<Integer> idxs = hs.iterator();
            while(idxs.hasNext()){
                oil += hm.get(idxs.next());
            }
        
            answer = Math.max(oil, answer);
        }
        
        return answer;
    }
    public int bfs(int[][] land, int x, int y, int group_idx){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        group[x][y] = group_idx;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            cnt++;
            int now_x = temp[0]; int now_y = temp[1];
            for(int i = 0; i < 4; i++){
                int nx = now_x + dir_x[i];
                int ny = now_y + dir_y[i];
                if(0 <= nx && nx < w && 0 <= ny && ny < h && 
                    land[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    group[nx][ny] = group_idx;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        hm.put(group_idx, cnt);
        return cnt;
    }
}
