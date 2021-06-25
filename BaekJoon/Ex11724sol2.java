package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11724sol2 {
	// 10 : 54	
	static int[][] graph;
	static boolean[] visited;
	
	static void dfs(int x) {
		visited[x] = true;
		
		for(int i = 0; i < graph[x].length; i++) {
			if(!visited[i] && graph[x][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		graph = new int[v+1][v+1];
		visited = new boolean[v+1];
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		int cnt = 0;
		for(int i = 1; i <= v; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
		
		
	}
	
}