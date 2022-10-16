package B1260;

import java.util.*;
import java.io.*;


public class Ex1260sol3 {
	
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	static StringBuilder sb;
	
	static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[x] = true;
		queue.offer(x);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			sb.append(num + " ");
			
			for(int i = 0; i < list.get(num).size(); i++) {
				if(!visited[list.get(num).get(i)]) {
					queue.offer(list.get(num).get(i));
					visited[list.get(num).get(i)] = true;
				}
			}
		}
	}
	
	static void dfs(int x) {
		visited[x] = true;
		sb.append(x + " ");
		for(int i = 0; i < list.get(x).size(); i++) {
			if(!visited[list.get(x).get(i)]) {
				visited[list.get(x).get(i)] = true;
				dfs(list.get(x).get(i));
			}
		}
	}
	
	// 7 : 10 20min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= v; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i <= v; i++) {
			Collections.sort(list.get(i));
		}
		
		sb = new StringBuilder();
		visited = new boolean[v+1];
		dfs(start);
		
		sb.append('\n');
		visited = new boolean[v+1];
		bfs(start);
		
		System.out.println(sb);
		
	}

}
