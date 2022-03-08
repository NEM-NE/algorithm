package B1753;

import java.io.*;
import java.util.*;

public class Practice {
    // 11:30
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>(); // 그래프
    static int[] dist; // 최단 거리를 저장하는 배열
    static boolean[] visited; // 방문했는지 확인하는

    static class Node {
        int idx, w; // 목적지, 비용

        public Node(int idx, int w){
            this.idx = idx;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        dist = new int[v+1];
        visited = new boolean[v+1];

        // 기본적인 초기화
        for(int i = 0; i <= v; i++){
            map.add(new ArrayList<Node>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // 값들 넣어준다.
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(u).add(new Node(x, w)); // Node로 넣어주고
        }

        solve(k);

        for(int i=1; i<=v; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }
    }

    private static void solve(int k){
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.w - o2.w);  // 우선순위 기준은 적은 비용부터 나오도록
        pq.add(new Node(k, 0)); // 시작점에서 시작점으로 가는 걸 넣는다. 그래서 비용은 0

        while(!pq.isEmpty()){
            Node a = pq.poll();
            if(visited[a.idx]) continue; // 방문했는지 체크(한번이라도 방문을 했다면 그 정점에 대해 모든 경로를 다 경험 것)

            visited[a.idx] = true;
            for(Node o : map.get(a.idx)){
                if(dist[o.idx] > dist[a.idx] + o.w){    // 기존에 잇는 값이 최적이냐 아니면 지금 뽑은 값에 대한 결과가 최적이냐 비교
                    dist[o.idx] = dist[a.idx] + o.w;   // 새로운게 최적이면 dist에 최신화 해주고
                    pq.add(new Node(o.idx, dist[o.idx])); //
                }
            }
        }
    }

}

/*
6 9
1
1 2 7
1 3 9
1 6 14
2 3 10
2 4 15
3 6 2
3 4 11
4 5 6
6 5 9
 */
