package B1012;

import java.io.*;
import java.util.*;

public class Main {
    // 18:00
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            int result = solve();
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static int solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[b][a] = 1;
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(j, i);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void dfs(int xStart, int yStart){
        visited[yStart][xStart] = true;

        for(int i = 0; i < 4; i++){
            int xx = xStart + dx[i];
            int yy = yStart + dy[i];

            if(xx < 0 || xx >= map[0].length || yy < 0 || yy >= map.length) continue;
            if(map[yy][xx] == 0 || visited[yy][xx]) continue;

            dfs(xx, yy);

        }
    }

}
