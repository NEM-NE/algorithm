package 퍼즐조각채우기;

import java.util.*;

public class Solution {
  // 9 : 42 - 2:07
  static boolean[][] isVisitedTable;
  static boolean[][] isVisitedGameBoard;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static int maxX = -1;
  static int minX = Integer.MAX_VALUE;
  static int maxY = -1;
  static int minY = Integer.MAX_VALUE;

  public int solution(int[][] game_board, int[][] table) {
    LinkedList<int[][]> shapeList = new LinkedList<>();
    isVisitedTable = new boolean[table.length][table[0].length];
    isVisitedGameBoard = new boolean[game_board.length][game_board[0].length];

    for(int i = 0; i < table.length; i++){
      for(int j = 0; j < table[0].length; j++){
        maxX = -1;
        minX = Integer.MAX_VALUE;
        maxY = -1;
        minY = Integer.MAX_VALUE;
        dfs(table, isVisitedTable, j, i);
        if(maxX != -1 && minX != Integer.MAX_VALUE && maxY != -1 && minY != Integer.MAX_VALUE){
          shapeList.add(createShape(table, maxX, minX, maxY, minY));
        }
      }
    }

    int result = 0;
    for(int i = 0; i < game_board.length; i++){
      for(int j = 0; j < game_board[0].length; j++){
        maxX = -1;
        minX = Integer.MAX_VALUE;
        maxY = -1;
        minY = Integer.MAX_VALUE;
        dfsGameBoard(game_board, j, i);
        if(maxX != -1 && minX != Integer.MAX_VALUE && maxY != -1 && minY != Integer.MAX_VALUE){
          int[][] shape = createShape(game_board, maxX, minX, maxY, minY);
          int num = equal(shapeList, shape);
          if(num != -1) {
            result += num;
          }
        }

      }
    }

    return result;
  }

  private static int equal(LinkedList<int[][]> shapeList, int[][] shape){
    int count = 0;
    for(int i = 0; i < shape.length; i++) {
      for (int j = 0; j < shape[0].length; j++) {
        if (shape[i][j] == 0)
          count++;
      }
    }

    for(int i = 0; i < shapeList.size(); i++){
      int[][] temp = shapeList.get(i);

      boolean isEqual = true;
      int x = 0;
      int y = 0;
      if(temp.length == shape.length && temp[0].length == shape[0].length){
        for(int j = 0; j < temp.length; j++){
          for(int k = 0; k < temp[0].length; k++){
            if(temp[j][k] == shape[j][k]) isEqual = false;
          }
        }
        if(isEqual) {
          shapeList.remove(temp);
          return count;
        }

        isEqual = true;
        for(int j = temp.length - 1; j >= 0; j--){
          for(int k = temp[0].length - 1; k >= 0; k--){
            if(temp[j][k] == shape[temp.length - 1 - j][temp[0].length - 1 - k]) isEqual = false;
          }
        }
        if(isEqual) {
          shapeList.remove(temp);
          return count;
        }
      }



      if(temp.length == shape[0].length && temp[0].length == shape.length){
        isEqual = true;
        for(int j = 0; j < temp[0].length; j++){
          for(int k = temp.length - 1; k >= 0; k--){
            if(temp[k][j] == shape[j][temp.length - 1 - k]) isEqual = false;
          }
        }
        if(isEqual) {
          shapeList.remove(temp);
          return count;
        }

        isEqual = true;
        for(int j = temp[0].length - 1; j >= 0; j--){
          for(int k = 0; k < temp.length; k++){
            if(temp[k][j] == shape[temp[0].length - 1 - j][k]) isEqual= false;
          }
          y++;
        }
        if(isEqual) {
          shapeList.remove(temp);
          return count;
        }
      }

    }

    return -1;
  }


  private int[][] createShape(int[][] base, int maxX, int minX, int maxY, int minY){
    int[][] shape = new int[maxY-minY+1][maxX-minX+1];

    for(int i = 0; i < shape.length; i++){
      for(int j = 0; j < shape[0].length; j++){
        shape[i][j] = base[minY+i][minX+j];
      }
    }

    return shape;
  }

  private void dfsGameBoard(int[][] map, int x, int y){
    if(isVisitedGameBoard[y][x] || map[y][x] == 1) return;

    isVisitedGameBoard[y][x] = true;
    maxX = Math.max(maxX, x);
    maxY = Math.max(maxY, y);
    minX = Math.min(minX, x);
    minY = Math.min(minY, y);

    for(int i = 0; i < 4; i++){
      int xx = x + dx[i];
      int yy = y + dy[i];

      if(yy < 0 || yy >= map.length || xx < 0 || xx >= map[0].length) continue;
      if(isVisitedGameBoard[yy][xx] || map[yy][xx] == 1) continue;

      dfsGameBoard(map, xx, yy);
    }
  }

  private void dfs(int[][] map, boolean[][] visited, int x, int y){
    if(visited[y][x] || map[y][x] == 0) return;

    visited[y][x] = true;
    maxX = Math.max(maxX, x);
    maxY = Math.max(maxY, y);
    minX = Math.min(minX, x);
    minY = Math.min(minY, y);

    for(int i = 0; i < 4; i++){
      int xx = x + dx[i];
      int yy = y + dy[i];

      if(yy < 0 || yy >= map.length || xx < 0 || xx >= map[0].length) continue;
      if(visited[yy][xx] || map[yy][xx] == 0) continue;

      dfs(map, visited, xx, yy);
    }

  }
}
