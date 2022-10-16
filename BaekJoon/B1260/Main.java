package B1260;

import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static StringTokenizer st;
  static boolean[] visited;

  public static void main(String[] args) throws Exception{
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    for(int i = 0; i < n+1; i++){
      graph.add(new ArrayList<>());
    }

    for(int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    for(int i = 0; i < n+1; i++){
      graph.get(i).sort((a, b) -> a - b);
    }

    visited = new boolean[n+1];
    dfs(v);
    sb.append("\n");
    visited = new boolean[n+1];
    bfs(v);

    System.out.println(sb);
  }

  static void dfs(int x) {
    visited[x] = true;
    sb.append(x + " ");
    for(int i = 0; i < graph.get(x).size(); i++){
      if(!visited[graph.get(x).get(i)]){
        dfs(graph.get(x).get(i));
      }
    }
  }

  static void bfs(int x){
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(x);
    visited[x] = true;

    while(!queue.isEmpty()){
      int num = queue.poll();
      for(int i = 0; i < graph.get(num).size(); i++){
        if(!visited[graph.get(num).get(i)]){
          visited[graph.get(num).get(i)] = true;
          queue.offer(graph.get(num).get(i));
        }
      }
      sb.append(num + " ");
    }
  }

}
