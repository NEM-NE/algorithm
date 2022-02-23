package B11724;

import java.io.*;
import java.util.*;

public class Ex11724sol3 {	
    // 11:26
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] isVisited;
	public static void main(String[] args) throws IOException {		
        st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        isVisited = new boolean[v+1];

        for(int i = 0; i < v + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int sum = 0;
        for(int i = 1; i < v+1; i++){
            if(!isVisited[i]){
                dfs(i);
                sum++;
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }

    public static void dfs(int tc){
        isVisited[tc] = true;

        for(int i = 0; i < graph.get(tc).size(); i++){
            if(!isVisited[graph.get(tc).get(i)]){
                dfs(graph.get(tc).get(i));
            }
        }
    }
    
}