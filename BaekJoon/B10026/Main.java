package B10026;

import java.util.*;
import java.io.*;

public class Main {
    // 1:35
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
        visited = new boolean[tc][tc];

        for(int i = 0; i < tc; i++){
            String str = br.readLine();
            for(int j = 0; j < tc; j++){
                char color = str.charAt(j);

                if(color == 'B'){
                    map[i][j] = -1;
                }else if(color == 'R'){
                    map[i][j] = 1;
                }
            }
        }

        int generalSum = 0;
        for(int i = 0; i < tc; i++) {
            for (int j = 0; j < tc; j++) {
                if(!visited[i][j]){
                    if(map[i][j] == 1){
                        dfs(j, i, 1);
                    }else if(map[i][j] == 0){
                        dfs(j, i, 0);
                    }else {
                        dfs(j, i, -1);
                    }
                    generalSum++;
                }
            }
        }

        visited = new boolean[tc][tc];
        int specialSum = 0;
        for(int i = 0; i < tc; i++) {
            for (int j = 0; j < tc; j++) {
                if(!visited[i][j]){
                    if(map[i][j] == -1){
                        dfs(j, i, -1);
                    }else {
                        dfs(j, i, 1, 0);
                    }
                    specialSum++;
                }
            }
        }

        sb.append(generalSum).append(" ").append(specialSum);
        System.out.println(sb);
    }

    static void dfs(int xStart, int yStart, int... findNums){
        visited[yStart][xStart] = true;

        for(int i = 0; i < 4; i++){
            int xx = xStart + dx[i];
            int yy = yStart + dy[i];

            if(xx < 0 || xx >= map[0].length || yy < 0 || yy >= map.length) continue;
            if(visited[yy][xx]) continue;
            boolean isSame = false;
            for(int num : findNums){
                if(map[yy][xx] == num) isSame = true;
            }

            if(isSame){
                dfs(xx, yy, findNums);
            }
        }

    }

}
