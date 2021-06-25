package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11725 {
	// 2 : 31
	
	static int[] parentAry;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	
	static void dfs(int x) {
		visited[x] = true;
		
		for(int i = 0; i < tree[x].size(); i++) {
			if(!visited[tree[x].get(i)]) {
				parentAry[tree[x].get(i)] = x;
				dfs(tree[x].get(i));
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
		parentAry = new int[tc+1];
		
		for(int i = 1; i <= tc; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
			
		}
		
		dfs(1);
		
		for(int i = 2; i < parentAry.length; i++) {
			sb.append(parentAry[i]).append('\n');
		}
		
		System.out.println(sb);
		
	}

}