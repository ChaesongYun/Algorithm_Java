import java.util.*;
import java.io.*;

public class b22865 {
    static ArrayList<Node> lst[];

    static int N, A, B, C;

    static class Node implements Comparable<Node> {
        int n, w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        lst = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lst[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            lst[D].add(new Node(E, L));
            lst[E].add(new Node(D, L));
        }

        int dist1[] = shortestWay(A); // A에서 거리를 구한다면?
        int dist2[] = shortestWay(B); // B에서 거리를 구한다면?
        int dist3[] = shortestWay(C); // C에서 거리를 구한다면?
        int max = -1;
        int idx = -1; // 어디에 위치하는 게 가장 멀까?
        for (int i = 1; i <= N; i++) {
            int a = dist1[i];
            int b = dist2[i];
            int c = dist3[i];
            int min = Math.min(a, Math.min(b, c)); // i -> A (or B or C) 중 가장 가까운 거리
            if(max < min){ // max 보다 min 값이 크다 -> A, B, C에 가는 최소 거리가 더 먼 위치가 있다
                max = min;
                idx = i;
            }
        }
        System.out.println(idx);
    }
        static int[] shortestWay ( int start){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean visit[] = new boolean[N + 1];
            int dist[] = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            pq.add(new Node(start, 0));
            while (!pq.isEmpty()) {
                Node tmp = pq.poll();
                if (visit[tmp.n]) continue;
                visit[tmp.n] = true;
                for (Node nxt : lst[tmp.n]) {
                    if (dist[nxt.n] > dist[tmp.n] + nxt.w) {
                        dist[nxt.n] = dist[tmp.n] + nxt.w;
                        pq.add(new Node(nxt.n, dist[nxt.n]));
                    }
                }
            }
            return dist;
        }
}
