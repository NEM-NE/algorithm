package B17135;

import java.io.*;
import java.util.*;

// 130m
public class Main {

  static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static private StringTokenizer st;
  static private StringBuilder sb = new StringBuilder();
  static LinkedList<LinkedList<Integer>> map = new LinkedList<>();
  static LinkedList<List<Point>> list = new LinkedList<>();
  static boolean[][] visited2;


  public static void main(String[] args) throws Exception{
    st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      map.add(new LinkedList<>());
      for(int j = 0; j< m; j++){
        map.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }

    // 각 x 좌표마다 1명을 배치 하여 죽일 수 있는 적의 좌표를 기록한다.
    for(int i = 0; i < m; i++){
      list.add(calculate(d, i));
    }

    int result = 0;
    // 3명의 궁수가 위치할 수 있는 모든 경우의 수에서 하나의 배열
    for(int i = 0; i < m; i++){
      for(int j = i+1; j < m; j++){
        for(int k = j+1; k < m; k++){
          boolean[][] visited = new boolean[n][m];

          List<Point> list1 = list.get(i);
          List<Point> list2 = list.get(j);
          List<Point> list3 = list.get(k);

          fill(visited, list1);
          fill(visited, list2);
          fill(visited, list3);

          result = Math.max(result, count(visited));

        }
      }
    }

    sb.append(result);
    System.out.println(sb);
  }

  private static int count(boolean[][] visited) {
    int count = 0;
    for(int i = 0; i < visited.length; i++){
      for(int j = 0; j < visited[0].length; j++){
        if(visited[i][j]) count++;
      }
    }

    return count;
  }

  private static void fill(boolean[][] visited, List<Point> list) {
    for(int i = 0; i < list.size(); i++){
      Point point = list.get(i);
      visited[point.y][point.x] = true;
    }
  }

  public static List calculate(int d, int x){
    ArrayList<Point> list = new ArrayList<>();
    visited2 = new boolean[map.size()][map.get(0).size()];
    int length = map.size() - 1;
    for(int i = 0; i < length; i++){
      int level = 0;
      LinkedList<Integer> list2 = new LinkedList<>();
      for(int j = 0; j < map.get(0).size(); j++){
        list2.add(0);
      }
      map.add(0, list2);
      map.pollLast();
      findEnemy(list, level, d, x, length);
    }
    return list;
  }

    public static void findEnemy(ArrayList<Point> list, int level, int d, int x, int y){
      while(level < d){
        //left
        int yy = 0;
        for(int j = x - level; j < x; j++){
          if(y-yy < 0 || j < 0) continue;
          if(map.get(y-yy).get(j) == 1 && !visited2[y-yy][j]){
            list.add(new Point(j, y-yy));
            visited2[y-yy][j] = true;
            return;
          }
          yy++;
        }
        //center
        if(y-level >= 0){
          if(map.get(y - level).get(x) == 1 && !visited2[y-level][x]){
            list.add(new Point(x, y-level));
            visited2[y-level][x] = true;
            return;
          }
        }

        //right
        yy = y - level;
        for(int j = x + 1; j <= x + level; j++){
          if(yy < 0 || j >= map.get(0).size()) continue;
          if(map.get(yy).get(j) == 1 && !visited2[yy][j]){
            list.add(new Point(j, yy));
            visited2[yy][j] = true;
            return;
          }
          yy--;
        }
        level++;
      }
    }

  static class Point {
    int x, y;

    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}

/*
3 10 10
1 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 1 0 1
0 0 0 0 0 0 0 0 0 0
 */
