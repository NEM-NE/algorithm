package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2667 {
	// 10 : 59
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {0, -1, 1, 0};
	static int[] dy = {-1, 0, 0, 1};
	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<Integer> house = new ArrayList<Integer>();
	static int ho;
	
	static void bfs(int x, int y) {
		visited[x][y] = true;
		ho++;
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(x, y));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];


				if(xx > 0 && yy > 0 && xx < graph.length && yy < graph.length) {
					if(graph[xx][yy] == 1 && !visited[xx][yy]) {
						visited[xx][yy] = true;
						que.offer(new Node(xx, yy));
						ho++;
					}
				}
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		graph = new int[tc+1][tc+1];
		visited = new boolean[tc+1][tc+1];
		
		for(int i = 1; i <= tc; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				int num = str.charAt(j) - '0';
				graph[j+1][i] = num;
			}
		}
		
		int cnt = 0;
		for(int i = 1; i <= tc; i++) {
			for(int j = 1; j <= tc; j++) {
				if(!visited[j][i] && graph[j][i] == 1) {
					ho = 0;
					bfs(j, i);
					house.add(ho);
					cnt++;
				}
				
			}
		}
		
		sb.append(cnt).append('\n');
		house.sort(null);
		for(int i = 0; i < house.size(); i++) {
			sb.append(house.get(i)).append('\n');
		}
		System.out.println(sb);
		
		

	}
	
}