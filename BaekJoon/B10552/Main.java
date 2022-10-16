package B10552;

import java.util.*;
import java.io.*;

// 3: 33
public class Main {


  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static ArrayList<ArrayList<Pensioners>> graph = new ArrayList<>();
  static StringTokenizer st;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());

    for(int i = 0; i < m + 1; i++){
      graph.add(new ArrayList<>());
    }

    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      int favoriteChannel = Integer.parseInt(st.nextToken());
      int hateChannel = Integer.parseInt(st.nextToken());

      graph.get(hateChannel).add(new Pensioners(i, favoriteChannel, hateChannel));
    }

    for(int i = 0; i < m + 1; i++){
      graph.get(i).sort((a, b) -> a.age - b.age);
    }

    visited = new boolean[m+1];
    dfs(p, 0);


    System.out.println(sb.length() == 0 ? -1 : sb);
  }

  static void dfs(int p, int count){
    if(graph.get(p).isEmpty()) {
      sb.append(count);
      return;
    }

    visited[p] = true;
    if(!visited[graph.get(p).get(0).favoriteChannel]) {
      dfs(graph.get(p).get(0).favoriteChannel, count+1);
    }
  }

  static class Pensioners {
    int age;
    int favoriteChannel;
    int hateChannel;

    public Pensioners(int age, int favoriteChannel, int hateChannel) {
      this.age = age;
      this.favoriteChannel = favoriteChannel;
      this.hateChannel = hateChannel;
    }
  }
}
