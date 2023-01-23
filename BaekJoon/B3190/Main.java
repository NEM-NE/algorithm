package B3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 2 : 32
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;
  private static int dx = 1;
  private static int dy = 0;

  static class Point {
    int x, y;

    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
  public static void main(String[] args) throws Exception{
    int n = Integer.parseInt(br.readLine());
    boolean[][] appleMap = new boolean[n][n];
    boolean[][] snakeMap = new boolean[n][n];
    LinkedList<Point> snakeList = new LinkedList<>();

    int k = Integer.parseInt(br.readLine());
    for(int i = 0; i < k; i++){
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());

      appleMap[y-1][x-1] = true;
    }

    int l = Integer.parseInt(br.readLine());
    HashMap<Integer, Character> dirMap = new HashMap<>();
    for(int i = 0; i < l; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      char dir = st.nextToken().charAt(0);
      dirMap.put(x, dir);
    }

    int headX = 0;
    int headY = 0;
    int time = 0;
    snakeList.add(new Point(headX, headY));
    snakeMap[headY][headX] = true;

    while(true){
      // dirMap을 통해 방향 전환 여부 확인
      if(dirMap.containsKey(time)){
        changeDirection(dirMap.get(time));
      }

      // 이동 (부딪히는 경우 확인하면서, snakeMap 기록, tail/head 변수 업데이트)
      int newX = headX+dx;
      int newY = headY+dy;
      if(newX >= snakeMap.length || newY >= snakeMap.length || newX < 0 || newY < 0) break;
      if(snakeMap[newY][newX]) break; // 자기 몸에 부딪히는 경우

      snakeMap[newY][newX] = true;
      snakeList.add(new Point(headX+dx, headY+dy));

      if(!appleMap[newY][newX]) { // 이동한 경로에 사과가 없는 경우
        Point point = snakeList.pollFirst();
        snakeMap[point.y][point.x] = false;
      }else {
        appleMap[newY][newX] = false;
      }

      headX = newX;
      headY = newY;

      time++;
    }

    sb.append(time+1);
    System.out.println(sb);
  }

  public static void changeDirection(char oper) {
    if (dx == 0 && dy == 1) {
      if (oper == 'D') {
        dx = -1;
      } else {
        dx = 1;
      }
      dy = 0;
    } else if (dx == 0 && dy == -1) {
      if (oper == 'D') {
        dx = 1;
      } else {
        dx = -1;
      }
      dy = 0;
    } else if (dx == 1 && dy == 0) {
      if (oper == 'D') {
        dy = 1;
      } else {
        dy = -1;
      }
      dx = 0;
    } else if (dx == -1 && dy == 0) {
      if (oper == 'D') {
        dy = -1;
      } else {
        dy = 1;
      }
      dx = 0;
    }
  }
}
