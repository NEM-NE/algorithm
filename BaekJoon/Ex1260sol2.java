package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1260sol2 {
	// 10 : 39	
	
	static int[][] graph;
	static StringBuilder sb;
	static boolean[] visited;
	
	static void dfs(int x) {
		visited[x] = true;
		sb.append(x).append(" ");
		for(int i = 0; i < graph[x].length; i++) {
			if(!visited[i] && graph[x][i] == 1) dfs(i);
		}
	}
	
	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(x);
		visited[x] = true;
		while(!que.isEmpty()) {
			int num = que.poll();
			sb.append(num).append(" ");
			
			for(int i = 0; i < graph[num].length; i++) {
				if(!visited[i] && graph[num][i] == 1) {
					que.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		graph = new int[v+1][v+1];
		visited = new boolean[v+1];
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		dfs(start);
		visited = new boolean[v+1];
		sb.append('\n');
		bfs(start);
		
		System.out.println(sb);
	}
	
}