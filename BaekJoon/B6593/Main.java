package B6593;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 4:39
public class Main {
  private static boolean[][][] map;
  private static boolean[][][] visited;

  private static int[] dx = {0, 0, 0, 1, 0, -1};
  private static int[] dy = {0, 0, -1, 0, 1, 0};
  private static int[] dz = {1, -1, 0, 0, 0, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (l == 0 && r == 0 && c == 0) break;

      map = new boolean[l][r][c];
      visited = new boolean[l][r][c];
      Point start = new Point(0, 0, 0);
      Point end = new Point(0, 0, 0);

      // set data
      for(int i = 0; i < l; i++){
        for(int j = 0; j < r; j++){
          String str = br.readLine();
          for(int k = 0; k < str.length(); k++){
            char cur = str.charAt(k);

            if(cur == 'S'){
              start = new Point(k, j, i);
            }else if(cur == 'E'){
              end = new Point(k, j, i);
              map[i][j][k] = true;
            }else {
              map[i][j][k] = cur == '.';
            }
          }
        }
        // jump the empty line
        br.readLine();
      }

      // calculate
      int result = bfs(start, end);

      // print result
      if (result == -1){
        sb.append("Trapped!");
      }else {
        sb.append(String.format("Escaped in %s minute(s).", result));
      }

      sb.append("\n");

    }

    System.out.println(sb);
  }

  public static int bfs(Point start, Point end){
    Queue<Point> queue = new LinkedList<>();
    queue.add(start);
    visited[start.z][start.y][start.x] = true;
    int count = 0;

    while(!queue.isEmpty()){
      int size = queue.size();

      for (int j = 0; j < size; j++) {
        Point point = queue.poll();
        visited[point.z][point.y][point.x] = true;
        for(int i = 0; i < 6; i++){
          int xx = point.x + dx[i];
          int yy = point.y + dy[i];
          int zz = point.z + dz[i];

          // validate
          if(xx < 0 || yy < 0 || zz < 0 || xx >= map[0][0].length || yy >= map[0].length || zz >= map.length) continue;
          if(!map[zz][yy][xx] || visited[zz][yy][xx]) continue;
          // check end point
          if(xx == end.x && yy == end.y && end.z == zz){
            return count + 1;
          }

          visited[zz][yy][xx] = true;
          queue.offer(new Point(xx, yy, zz));
        }
      }

      count++;
    }

    return -1;
  }

  static class Point {
    int x, y, z;

    public Point(int x, int y, int z){
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }
}