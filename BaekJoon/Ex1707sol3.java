package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1707sol3 {
	// 9 : 52
	
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;
	static boolean isBipartie;
	
	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(x);
		visited[x] = 1;
		
		while(!que.isEmpty()) {
			int num = que.poll();
			
			for(int i = 0; i < graph.get(num).size(); i++) {
				if(visited[graph.get(num).get(i)] == 0) {
					que.offer(graph.get(num).get(i));
					visited[graph.get(num).get(i)] = visited[num] * -1;
				}else if(visited[graph.get(num).get(i)] == visited[num]){
					isBipartie = false;
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<ArrayList<Integer>>();
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
				if(visited[j] == 0 && isBipartie) {
					bfs(j);
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