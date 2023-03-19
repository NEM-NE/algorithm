package B2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//11:03
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static boolean[][] map;
  private static boolean[][][] vistied;

  private static int[] dx = {0, 1, 0, -1};
  private static int[] dy = {-1, 0, 1, 0};


  /*
 TestCase

-> 뚫고 보니 오래걸리는 경우
8 4
0000
1110
0010
1010
1010
0010
0100
0000
-> 11

3 / 5 - 2
먼저 뚫기 -> 18
나중에 뚫기 -> 15
-> 먼저 뚫는 것보다 나중에 뚫는 것이 더 좋을 경우
9 4
0011
1011
0011
0111
0000
1110
0000
0111
0000
-> 15
   */

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int y = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    map = new boolean[y][x];
    vistied = new boolean[2][y][x]; // 0 -> not use drill yet. / 1 -> use drill
    for (int i = 0; i < y; i++) {
      String str = br.readLine();
      for(int j = 0; j < str.length(); j++){
        char cur = str.charAt(j);
        map[i][j] = cur == '0';
      }
    }

    int result = bfs(new Point(0, 0, true));
    sb.append(result);
    System.out.println(sb);
  }

  static int bfs(Point p){
    Queue<Point> queue = new LinkedList<>();
    queue.add(p);
    vistied[0][p.y][p.x] = true;

    int count = 1;
    while(!queue.isEmpty()){
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        Point point = queue.poll();

        if (point.y == map.length - 1 && point.x == map[0].length - 1){
          return count;
        }

        for(int i = 0; i < 4; i++){
          int xx = point.x + dx[i];
          int yy = point.y + dy[i];

          if(xx < 0 || xx >= map[0].length || yy < 0 || yy >= map.length) continue;

          if((!map[yy][xx] && point.canBreak) || (map[yy][xx] && !point.canBreak)){ // there is the wall but, it can through || there is no the wall and hasn't drill
            if(vistied[1][yy][xx]) continue;
            vistied[1][yy][xx] = true;
            queue.add(new Point(xx, yy, false));
          }else if (map[yy][xx] && point.canBreak){ // there is no the wall and has drill
            if(vistied[0][yy][xx]) continue;
            vistied[0][yy][xx] = true;
            queue.add(new Point(xx, yy, true));
          }
        }
      }

      count++;
    }

    return -1;
  }

  static class Point {
    int x, y;
    boolean canBreak;

    public Point(int x, int y, boolean canBreak){
      this.x = x;
      this.y = y;
      this.canBreak = canBreak;
    }
  }

}
