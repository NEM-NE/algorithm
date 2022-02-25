package B2468;

import java.util.*;
import java.io.*;

public class Main {
    // 4:48
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        map = new int[tc][tc];

        int max = 0;
        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < tc; j++){
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                map[i][j] = num;
            }
        }

        int sum = 0;
        for(int i = 0; i <= max; i++){
            visited = new boolean[tc][tc];
            int result = 0;
            for(int y = 0; y < map.length; y++){
                for(int x = 0; x < map[0].length; x++){
                    if(!visited[y][x] && map[y][x] > i){
                        dfs(x, y, i);
                        result++;
                    }
                }
            }

            sum = Math.max(sum, result);
        }

        sb.append(sum);
        System.out.println(sb);

    }

    static void dfs(int x, int y, int line){
        visited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx < 0 || xx >= map.length || yy < 0 || yy >= map.length) continue;
            if(visited[yy][xx] || map[yy][xx] <= line) continue;

            dfs(xx, yy, line);
        }

    }



}
