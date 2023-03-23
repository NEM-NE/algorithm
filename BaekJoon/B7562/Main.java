package B7562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12:15
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;
  private static boolean[][] map;
  private static boolean[][] visited;

  private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
  private static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

  public static void main(String[] args) throws Exception {
    int tc = Integer.parseInt(br.readLine());

    for(int k = 0; k < tc; k++){
      int size = Integer.parseInt(br.readLine());

      map = new boolean[size][size];
      visited = new boolean[size][size];

      st = new StringTokenizer(br.readLine());
      int startX = Integer.parseInt(st.nextToken());
      int startY = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int endX = Integer.parseInt(st.nextToken());
      int endY = Integer.parseInt(st.nextToken());

      int result = bfs(startX, startY, endX, endY);
      sb.append(result).append("\n");
    }

    System.out.println(sb);
  }

  private static int bfs(int startX, int startY, int endX, int endY) {
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(startX, startY));
    visited[startY][startX] = true;

    int count = 0;
    while(!queue.isEmpty()) {
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        Point point = queue.poll();

        if(point.x == endX && point.y == endY){
          return count;
        }

        for (int i = 0; i < dx.length; i++) {
          int xx = point.x + dx[i];
          int yy = point.y + dy[i];

          if(xx < 0 || xx >= map[0].length || yy < 0 || yy >= map.length) continue;
          if(visited[yy][xx]) continue;

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
