package B1743;

import java.io.*;
import java.util.*;

public class Main {
    // 11:30
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    max = Math.max(max, dfs(j, i));
                }
            }
        }

        sb.append(max);
        System.out.println(sb);
    }

    static int dfs(int xStart, int yStart){
        visited[yStart][xStart] = true;

        int result = 1;
        for(int i = 0; i < 4; i++){
            int xx = xStart + dx[i];
            int yy = yStart + dy[i];

            if(xx < 1 || xx >= map[0].length || yy < 1 || yy >= map.length) continue;
            if(visited[yy][xx] || map[yy][xx] == 0) continue;
            result += dfs(xx, yy);
        }

        return result;
    }

}
