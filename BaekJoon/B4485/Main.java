package B4485;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static final int INF = 400000;

    static class Node {
        int x, y, w;

        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());

        int idx = 1;
        while(n != 0){
            visited = new boolean[n][n];
            map = new int[n][n];
            dist = new int[n][n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            solve(0, 0);
            sb.append("Problem " + idx + ": " +dist[n-1][n-1]).append("\n");
            idx++;
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }

    private static void solve(int x, int y){
        dist[y][x] = map[y][x];
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Node(x, y, map[y][x]));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.y][node.x]) continue;
            visited[node.y][node.x] = true;
            for(int i = 0; i < 4; i++){
                int xx = node.x + dx[i];
                int yy = node.y + dy[i];

                if(yy < 0 || yy >= dist.length || xx < 0 || xx >= dist.length) continue;
                if(dist[yy][xx] > dist[node.y][node.x] + map[yy][xx]){
                    dist[yy][xx] = dist[node.y][node.x] + map[yy][xx];
                    pq.offer(new Node(xx, yy, dist[yy][xx]));
                }
            }
        }
    }
}
