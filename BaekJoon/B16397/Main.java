package B16397;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 4:40
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static boolean[] visited = new boolean[100000];

  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    int g = Integer.parseInt(st.nextToken());

    int result = bfs(n, t, g);
    if(n == g) {
      sb.append(0);
    }else if(result == -1){
      sb.append("ANG");
    }else {
      sb.append(t - result + 1);
    }

    System.out.println(sb);
  }

  public static int bfs(int n, int t, int g){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(n);
    visited[n] = true;
    while(!queue.isEmpty() && t != 0){
      int size = queue.size();
      for(int i = 0; i < size; i++){
        int num = queue.poll();

        if (num >= 99999){
          continue;
        }

        // press a btn
        int result = num + 1;
        if(result == g){
          return t;
        }
        if (!visited[result]){
          visited[result] = true;
          queue.add(result);
        }

        // press b btn
        if ((num * 2) > 99999) continue;
        result = executeLogicB(num);
        if (!visited[result]){
          visited[result] = true;
          if(result == g){
            return t;
          }
          queue.add(result);
        }
      }
      t--;
    }

    return -1;
  }

  public static int executeLogicB(int num) {
    num *= 2;
    if (num == 0) return 0;

    if(num / 10000 != 0){
      return num - 10000;
    }else if(num / 1000 != 0) {
      return num - 1000;
    }else if(num / 100 != 0) {
      return num - 100;
    }else if(num / 10 != 0) {
      return num - 10;
    }else {
      return num - 1;
    }
  }

}
