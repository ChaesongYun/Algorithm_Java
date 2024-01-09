import java.util.*;

class Solution{
    int N, E;
    int[][] matrix;
    public int solution(int n, int s, int a, int b, int[][] fares){
        N = n;
        E = fares.length;
        matrix = new int[N][N];
        
        for(int i = 0; i < E; i++){
            int u = fares[i][0] - 1;
            int v = fares[i][1] - 1;
            int w = fares[i][2];
            matrix[u][v] = w;
            matrix[v][u] = w;
        }
        
        // 시작점에서 각 지점까지 가장 짧은 거리를 계산
        int[] together = dijkstra(s-1);
        int minCost = together[a-1] + together[b-1];
        for(int i = 0; i < N; i++){
            // i 지점까지 같이 가고 i -> a, i -> b 값 계산해서
            // (s -> i -> a) + (s -> i -> b) 값 중 최소값 계산
            // 같이 가는 일 없이 따로 가게 되는 경우는 i가 s일 때 계산됨
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a-1] + alone[b-1];
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }
    public int[] dijkstra(int start){
        // 첫번째는 가중치, 두번째는 도착지점
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            return o1[0]-o2[0];
        });
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[] {0, start});
        
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int u = temp[1];
            if(visited[u]) continue;
            visited[u] = true;
            for(int v = 0; v < N; v++){
                if(matrix[u][v] == 0) continue;
                if(dist[u] + matrix[u][v] < dist[v]){
                    dist[v] = dist[u] + matrix[u][v];
                    pq.add(new int[]{dist[v], v});
                }
            }
        }
        
        return dist;
    }
}
