package B11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    // 18:00
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                dfs(i, visited);
                cnt++;
            }
        }

        sb.append(cnt);
        System.out.println(sb);
    }

    public static void dfs(int start, boolean[] visited){
        visited[start] = true;

        for(int i = 0; i < graph.get(start).size(); i++){
            if(!visited[graph.get(start).get(i)]){
                dfs(graph.get(start).get(i), visited);
            }
        }
    }
}
