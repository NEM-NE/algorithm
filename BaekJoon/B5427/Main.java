package B5427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 4:10
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static int[] dx = {0, 1, 0, -1};
  private static int[] dy = {-1, 0, 1, 0};

  public static void main(String[] args) throws Exception {
    int tc = Integer.parseInt(br.readLine());

    for(int k = 0; k < tc; k++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      char[][] map = new char[h][w];
      boolean[][] visited = new boolean[h][w];
      Point start = null;
      LinkedList<Point> fireSpots = new LinkedList<>();
      for (int i = 0; i < h; i++) {
        String str = br.readLine();
        for(int j = 0; j < w; j++){
          char cur = str.charAt(j);

          if(cur == '@') {
            start = new Point(j, i);
          }else if(cur == '*') {
            fireSpots.add(new Point(j, i));
          }

          map[i][j] = cur;
        }
      }

      int result = bfs(map, visited, start, fireSpots);

      if (result == -1){
        sb.append("IMPOSSIBLE");
      }else {
        sb.append(result);
      }

      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static int bfs(char[][] map, boolean[][] visited, Point start, LinkedList<Point> fireSpots){
    Queue<Point> queue = new LinkedList<>();
    queue.add(start);
    visited[start.y][start.x] = true;

    int count = 1;
    while(!queue.isEmpty()) {
      int size = queue.size();

      // calculate fire spots
      int fireSpotSize = fireSpots.size();
      for (int i = 0; i < fireSpotSize; i++) {
        Point point = fireSpots.poll();
        for(int j = 0; j < 4; j++){
          int xx = point.x + dx[j];
          int yy = point.y + dy[j];

          if (yy < 0 || xx < 0 || yy >= map.length || xx >= map[0].length) continue;
          if (map[yy][xx] == '.') {
            map[yy][xx] = '*';

            fireSpots.add(new Point(xx, yy));
          }
        }
      }

      // calculate cases that user moves every seconds
      for(int i = 0; i < size; i++){
        Point point = queue.poll();

        for(int j = 0; j < 4; j++){
          int xx = point.x + dx[j];
          int yy = point.y + dy[j];

          // exit the building
          if (yy < 0 || xx < 0 || yy >= map.length || xx >= map[0].length) {
            return count;
          }
          if(map[yy][xx] == '#' || map[yy][xx] == '*' || visited[yy][xx]) continue;

          visited[yy][xx] = true;
          queue.add(new Point(xx, yy));
        }
      }

      count++;
    }

    return -1;
  }

  static class Point {
    int x, y;

    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}
