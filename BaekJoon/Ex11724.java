package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11724 {
	// 09 : 58	
	static int[][] graph;
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	
	static void dfs(int x) {
		visited[x] = true;
		stack.remove((Integer) x);
		
		for(int i = 0; i < graph[x].length; i++) {
			if(!visited[i] && graph[x][i] == 1) dfs(i);
		}
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		//create grpah
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		// align list
		for(int i = 1; i <= n; i++) {
			stack.push(i);
		}
		
		// count component
		int cnt = 0;
		while(!stack.isEmpty()) {
			int index = stack.pop();
			if(index != 0) {
				dfs(index);
				cnt++;
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
		
		
	}
	
}