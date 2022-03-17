package B1504;

import java.util.*;
import java.io.*;

public class Main {
    //12:46
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>();
    static int[] dist;
    static boolean[] visited;
    static final int INF = 200000001;

    static class Node {
        int y, w;

        public Node(int y, int w){
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        for(int i = 0; i <= n; i++){
            map.add(new ArrayList<Node>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(a).add(new Node(b, w));
            map.get(b).add(new Node(a, w));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = solve(1, v1) + solve(v1, v2) + solve(v2, n);
        int result2 = solve(1, v2) + solve(v2, v1) + solve(v1, n);

        int answer = Math.min(result1, result2);

        sb.append(answer >= INF ? -1 : answer);
        System.out.println(sb);
    }

    private static int solve(int start, int end){
        Arrays.fill(dist, INF);
        dist[start] = 0;
        visited = new boolean[dist.length];

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.y]) continue;
            visited[node.y] = true;

            for(int i = 0; i < map.get(node.y).size(); i++){
                Node next = map.get(node.y).get(i);

                if(dist[next.y] > dist[node.y] + next.w){
                    dist[next.y] = dist[node.y] + next.w;
                    pq.offer(new Node(next.y, dist[next.y]));
                }
            }
        }

        return dist[end];
    }
}
