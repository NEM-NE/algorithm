package B17070;

import java.io.*;
import java.util.StringTokenizer;

// 1:32 - 2:43
public class Main {
  static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static private StringTokenizer st;
  static private StringBuilder sb = new StringBuilder();
  static int[][] map;
  static int[][] dx = {{1, 1}, {1, 1, 0}, {0, 1}}; // - \ | 방향 대로
  static int[][] dy = {{0, 1}, {0, 1, 1}, {1, 1}};
  static int[][] directions = {{0, 1}, {0, 1, 2}, {2, 1}};
  static int[][] pipeImpactRangesX = {{0}, {0, 0, -1}, {0}};
  static int[][] pipeImpactRangesY = {{0}, {-1, 0, 0}, {0}};
  static int count = 0;

  public static void main(String[] args) throws Exception{
    int n = Integer.parseInt(br.readLine());

    map = new int[n][n];
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int num = Integer.parseInt(st.nextToken());
        map[i][j] = num;
      }
    }

    solve(1, 0, 0);

    sb.append(count);
    System.out.println(sb);
  }

  public static void solve(int x, int y, int preDirection){
    if(x == map.length - 1 && y == map.length - 1) {
      count++;
      return;
    }

    for(int i = 0; i < dx[preDirection].length; i++){
      int xx = x + dx[preDirection][i];
      int yy = y + dy[preDirection][i];
      if(xx >= map.length || yy >= map.length) continue;
      if(canInstallPipe(xx, yy, directions[preDirection][i])) continue;
      solve(xx, yy, directions[preDirection][i]);
    }

  }

  public static boolean canInstallPipe(int x, int y, int direction){
    for(int i = 0; i < pipeImpactRangesX[direction].length; i++){
      int xx = x + pipeImpactRangesX[direction][i];
      int yy = y + pipeImpactRangesY[direction][i];

      if(map[yy][xx] == 1) {
        return true;
      }
    }

    return false;
  }
}
