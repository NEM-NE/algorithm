package B3055;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 5:22
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  private static char[][] map;
  private static boolean[][] visited;

  private static int[] dx = {0, 1, 0, -1};
  private static int[] dy = {-1, 0, 1, 0};

  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    map = new char[r][c];
    visited = new boolean[r][c];
    Point start = null;
    Point end = null;
    LinkedList<Point> waterSpots = new LinkedList<>();
    for (int i = 0; i < r; i++) {
      String str = br.readLine();
      for (int j = 0; j < c; j++){
        char cur = str.charAt(j);

        if (cur == 'S') {
          start = new Point(j, i);
        }else if(cur == 'D'){
          end = new Point(j, i);
        }else if(cur == '*'){
          waterSpots.add(new Point(j, i));
        }

        map[i][j] = cur;
      }
    }

    int result = bfs(waterSpots, start, end);
    if (result == -1){
      sb.append("KAKTUS");
    }else {
      sb.append(result);
    }

    System.out.println(sb);
  }

  private static int bfs(LinkedList<Point> waterSpots, Point start, Point end) {
    Queue<Point> queue = new LinkedList<>();
    queue.add(start);
    visited[start.y][start.x] = true;

    int count = 1;
    while(!queue.isEmpty()) {

      //calculate waterSpots
      int waterSpotSize = waterSpots.size();
      for(int i = 0; i < waterSpotSize; i++){
        Point point = waterSpots.poll();
        for(int j = 0; j < 4; j++){
          int xx = point.x + dx[j];
          int yy = point.y + dy[j];

          if(xx < 0 || yy < 0 || yy >= map.length || xx >= map[0].length) continue;
          if(map[yy][xx] != '.') continue;

          map[yy][xx] = '*';
          waterSpots.add(new Point(xx, yy));
        }
      }

      //calculate cases that hedgehog moves
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Point point = queue.poll();

        for(int j = 0; j < 4; j++) {
          int xx = point.x + dx[j];
          int yy = point.y + dy[j];

          if(xx < 0 || yy < 0 || yy >= map.length || xx >= map[0].length) continue;
          if(map[yy][xx] == 'D'){
            return count;
          }
          if(map[yy][xx] != '.' || visited[yy][xx]) continue;


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
