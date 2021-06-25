package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1967 {
	// 08 : 07
	
	static class Node{
		int num;
		int weight;
		Node(int num, int weight){
			this.num = num;
			this.weight = weight;
		}
	}
	
	static ArrayList<Node>[] tree;
	static int max, maxIndex;
	static boolean[] visited;
	
	static void dfs(int index, int len) {
		visited[index] = true;
		
		if(len > max) {
			max = len;
			maxIndex = index;
		}
		
		for(int i = 0; i < tree[index].size(); i++) {
			if(!visited[tree[index].get(i).num]) {
				dfs(tree[index].get(i).num, len + tree[index].get(i).weight);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[tc+1];
		visited = new boolean[tc+1];
		max = 0;
		maxIndex = 1;
		
		for(int i = 0; i <= tc; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			tree[parent].add(new Node(v, w));
			tree[v].add(new Node(parent, w));
		}
		
		dfs(1, 0);
		max = 0;
		visited = new boolean[tc+1];
		dfs(maxIndex, 0);
		
		sb.append(max);
		System.out.println(sb);
		
	}

}