package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1167 {
	// 2 : 56
	
	static class Node{
		int num, len;
		Node(int num, int len){
			this.num = num;
			this.len = len;
		}
	}
	
	static ArrayList<Node>[] tree;
	static boolean[] visited;
	static int dist, index;
	
	static void dfs(int x, int len) {
		visited[x] = true;
		
		if(len > dist) {
			dist = len;
			index = x;
		}
		
		for(int i = 0; i < tree[x].size(); i++) {
			if(!visited[tree[x].get(i).num]) {
				dfs(tree[x].get(i).num, len + tree[x].get(i).len);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[tc+1];
		visited = new boolean[tc+1];
		
		for(int i = 1; i <= tc; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			
			while(true) {
				int v = Integer.parseInt(st.nextToken());
				if(v == -1) break;
				int len = Integer.parseInt(st.nextToken());
				
				Node node = new Node(v, len);
				
				tree[index].add(node);
			}
			
		}
		
		dist = index = 0;
		dfs(1, 0);
		
		dist = 0;
		visited = new boolean[tc+1];
		dfs(index, 0);
		
		sb.append(dist);
		System.out.println(sb);
	}

}