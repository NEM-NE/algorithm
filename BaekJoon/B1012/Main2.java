package B1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4:12
public class Main2 {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static boolean[][] map;
  private static boolean[][] visited;

  private static int[] dx = {0, 1, 0, -1};
  private static int[] dy = {-1, 0, 1, 0};

  public static void main(String[] args) throws Exception{
    int tc = Integer.parseInt(br.readLine());

    for(int j = 0; j < tc; j++){
      // initialize
      st = new StringTokenizer(br.readLine());
      int width = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      int size = Integer.parseInt(st.nextToken());

      map = new boolean[height][width];
      visited = new boolean[height][width];
      for (int i = 0; i < size; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map[y][x] = true;
      }

      // calculate
      int count = 0;
      for (int i = 0; i < map.length; i++) {
        for (int k = 0; k < map[0].length; k++){
          if (map[i][k] && !visited[i][k]){
            dfs(k, i);
            count++;
          }
        }
      }

      sb.append(count).append("\n");
    }

    System.out.println(sb);
  }

  public static void dfs(int x, int y){
    visited[y][x] = true;

    for(int i = 0; i < 4; i++){
      int xx = dx[i] + x;
      int yy = dy[i] + y;

      if (xx >= map[0].length || xx < 0 || yy < 0 || yy >= map.length) continue;
      if (visited[yy][xx] || !map[yy][xx]) continue;

      dfs(xx, yy);
    }
  }

}
