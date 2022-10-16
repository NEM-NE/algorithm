package B2178;

import java.util.*;
import java.io.*;

public class Main {
    // 12:16
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) == '0' ? 0 : Integer.MAX_VALUE;
            }
        }

        visited = new boolean[n][m];
        bfs();

        sb.append(map[n-1][m-1]);
        System.out.println(sb);
    }

    static void bfs() {
        visited[0][0] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        map[0][0] = 1;

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(int i = 0; i < 4; i++){
                int xx = dx[i] + point.x;
                int yy = dy[i] + point.y;

                if(xx < 0 || xx >= map[0].length || yy < 0 || yy >= map.length) continue;
                if(visited[yy][xx]) continue;
                if(map[yy][xx] == 0) continue;

                map[yy][xx] = Math.min(map[point.y][point.x] + 1, map[yy][xx]);
                queue.offer(new Point(xx, yy));
                visited[yy][xx] = true;
            }
        }
    }

    static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
