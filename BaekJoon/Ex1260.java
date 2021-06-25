package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1260 {
	// 09 : 59
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static StringBuilder sb;
	
	static void dfs(int n) {
		visited[n] = true;
		sb.append(n).append(" ");
		
		for(int i = 0; i < graph.get(n).size(); i++) {
			if(!visited[graph.get(n).get(i)]) dfs(graph.get(n).get(i));
		}
	}
	
	static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(n);
		visited[n] = true;

		while(!que.isEmpty()) {
			int index = que.poll();
			sb.append(index).append(" ");
			
			for(int i = 0; i < graph.get(index).size(); i++) {
				if(!visited[graph.get(index).get(i)]) {
					que.offer(graph.get(index).get(i));
					visited[graph.get(index).get(i)] = true;
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

		visited = new boolean[v+1];
		
		for(int i = 0; i <= v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i = 0; i < v; i++) {
			graph.get(i).sort(null);
		}
		
		dfs(start);
		sb.append('\n');
		visited = new boolean[v+1];
		bfs(start);
		
		System.out.println(sb);
	}
	
}