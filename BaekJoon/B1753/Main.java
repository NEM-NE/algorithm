package B1753;

import java.io.*;
import java.util.*;

public class Main {
    // 14:24
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>();
    static int[] dist;
    static boolean[] visited;

    private static class Node {
        int x, w;
        public Node(int x, int w){
            this.x = x;
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

        for(int i = 0; i <= v; i++){
            map.add(new ArrayList<Node>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(u).add(new Node(x, w));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        solve(k);

        for(int i = 1; i < dist.length; i++){
            int num = dist[i];
            if(num == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else {
                sb.append(num).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void solve(int k){
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Node(k, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.x]) continue;;
            visited[node.x] = true;

            for(Node next : map.get(node.x)){
                if(dist[next.x] > dist[node.x] + next.w){
                    dist[next.x] = dist[node.x] + next.w;
                    pq.offer(new Node(next.x, dist[next.x]));
                }
            }
        }
    }

}
