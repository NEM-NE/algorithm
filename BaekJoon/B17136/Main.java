package B17136;

import java.io.*;
import java.util.*;

public class Main {

  //12:34
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;
  private static int[][] map = new int[10][10];
  private static int[] shapesCnt = {5, 5, 5, 5, 5};
  private static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws Exception {

    for (int i = 0; i < map.length; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < map[0].length; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0, 0);

    sb.append((result == Integer.MAX_VALUE) ? -1 : result);
    System.out.println(sb);
  }

  private static void dfs(int x, int y, int count){

    for (int i = y; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if(map[i][j] == 1){
          boolean flag = false;
          for(int k = shapesCnt.length - 1; k >= 0; k--){
            if(isPaste(k, j, i)){
              flag = true;
              shapesCnt[k] -= 1;
              drawMap(j, i, k, 0);

              // 재귀
              dfs(j, i, count+1);

              //map에 색칠 지우기
              shapesCnt[k] += 1;
              drawMap(j, i, k, 1);
            }
          }

          if(flag) return;
        }

        if(i == map.length - 1 && j == map[0].length - 1){
          if(isEmpty()){
            result = Math.min(result, count);
          }
        }
      }
    }
  }

  private static boolean isPaste(int level, int x, int y){
    if(shapesCnt[level] <= 0) return false;

    for(int j = 0; j <= level; j++){
      for(int k = 0; k <= level; k++){
        if(y + j >= map.length || x + k >= map[0].length) return false;
        if(map[y + j][x + k] == 0) return false;
      }
    }

    return true;
  }
  private static void drawMap(int x, int y, int level, int num) {
    for(int i = y; i <= y + level; i++){
      for(int j = x; j <= x + level; j++){
        map[i][j] = num;
      }
    }
  }

  private static boolean isEmpty(){
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if(map[i][j] == 1) {
          return false;
        }
      }
    }
    return true;
  }

}
