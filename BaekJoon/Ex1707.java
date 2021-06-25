package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1707 {
	// 10 : 04	
	
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;

	static boolean isBipartie;
	
	static void dfs(int x, int num) {
		visited[x] = num * -1;
		
		for(int i = 0; i < graph.get(x).size(); i++) {
			if(visited[graph.get(x).get(i)] == 0) {
				dfs(graph.get(x).get(i), num * -1);
			}else if(visited[graph.get(x).get(i)] == num * -1) {
				isBipartie = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			visited = new int[v+1];
			isBipartie = true;
			
			for(int j = 0; j <= v; j++) {
				graph.add(new ArrayList<>());
			}
			
			for(int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			for(int j = 1; j <= v; j++) {
				if(visited[j] == 0) {
					dfs(j, 1);
				}
			}
			
			if(isBipartie) {
				sb.append("YES").append('\n');
			}else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
}