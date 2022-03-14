package B1916;

import java.util.*;
import java.io.*;

public class Main {
    //1:00
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>();
    static int[] dist;
    static boolean[] visited;

    static class Node {
        int y, w;

        public Node(int y, int w){
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            map.add(new ArrayList<Node>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(x).add(new Node(y, w));
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        solve(x);
        sb.append(dist[y]);
        System.out.println(sb);
    }

    private static void solve(int start){
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
    }

}
