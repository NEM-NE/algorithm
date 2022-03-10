package B1753;

import java.io.*;
import java.util.*;

public class Main2 {
    // 3:6
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> map;
    static int[] dist;
    static boolean[] visited;

    static class Node {
        int y, w;

        public Node(int y, int w) {
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        map = new ArrayList<ArrayList<Node>>();
        dist = new int[v+1];
        visited = new boolean[v+1];
        for(int i = 0; i <= v; i++){
            map.add(new ArrayList<Node>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(u).add(new Node(y, w));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        solve(k);

        for(int i = 1; i < dist.length; i++){
            int result = dist[i];
            if(result == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void solve(int k){
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Node(k, 0));

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

    }

}
