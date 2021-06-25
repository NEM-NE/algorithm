package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10451sol2 {
	// 10 : 43	
	static int[] edge;
	static boolean[] visited;
	static int cnt;
	static void dfs(int x) {
		visited[x] = true;
		
		if(!visited[edge[x]]) dfs(edge[x]);
		
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i < tc; i++) {
			int num = Integer.parseInt(br.readLine());
			edge = new int[num+1];
			visited = new boolean[num+1];
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j < edge.length; j++) {
				edge[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = 1; j < visited.length; j++) {
				if(!visited[j]) {
					dfs(j);
					cnt++;
				}
			}
			
			sb.append(cnt).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
}