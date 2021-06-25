package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10451 {
	// 10 : 20	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int cnt;
	static int temp;
	
	static void dfs(int x) {
		if(temp == x && visited[x]) {
			cnt++;
			return;
		}
		visited[x] = true;
		for(int i = 0; i < graph.get(x).size(); i++) {
			dfs(graph.get(x).get(i));
		}
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i < tc; i++) {
			int v = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			visited = new boolean[v+1];
			graph = new ArrayList<>();
			cnt = 0;
			
			for(int j = 0; j <= v; j++) {
				graph.add(new ArrayList<>());
			}
			
			for(int j = 1; j <= v; j++) {
				int b = Integer.parseInt(st.nextToken());
				graph.get(j).add(b);
			}
			
			for(int j = 1; j <= v; j++) {
				if(!visited[j]) {
					temp = j;
					dfs(j);
				}
			}
			
			sb.append(cnt).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
}