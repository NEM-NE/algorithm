package B2583;

import java.util.*;
import java.io.*;

public class Main {
    // 12:53
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());

            int xStart = Integer.parseInt(st.nextToken());
            int yStart = Integer.parseInt(st.nextToken());
            int xEnd = Integer.parseInt(st.nextToken());
            int yEnd = Integer.parseInt(st.nextToken());

            paint(xStart, yStart, xEnd, yEnd);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++) {
                if(!visited[i][j] && map[i][j] == 0){
                    int result = dfs(j, i);
                    list.add(result);
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");

        for(int num : list){
            sb.append(num).append(" ");
        }

        System.out.println(sb);

    }

    static int dfs(int xStart, int yStart){
        visited[yStart][xStart] = true;

        int sum = 1;
        for(int i = 0; i < 4; i++){
            int xx = xStart + dx[i];
            int yy = yStart + dy[i];

            if(xx < 0 || xx >= map[0].length || yy < 0 || yy >= map.length) continue;
            if(visited[yy][xx] || map[yy][xx] == 1) continue;

            sum += dfs(xx, yy);
        }

        return sum;
    }

    private static void paint(int xStart, int yStart, int xEnd, int yEnd) {
        for(int i = yStart; i < yEnd; i++){
            for(int j = xStart; j < xEnd; j++){
                map[i][j] = 1;
            }
        }
    }

}
