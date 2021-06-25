package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2178 {
	// 13 : 07
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int Y, X;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	
	static void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<Node>();
		que.offer(new Node(x, y));
		visited[y][x] = 1;
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];
				
				if(xx > 0 && xx < X+1 && yy > 0 && yy < Y+1) {
					if(map[yy][xx] == 1 && visited[yy][xx] == 0) {
						que.offer(new Node(xx, yy));
						visited[yy][xx] = visited[node.y][node.x] + 1;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y+1][X+1];
		visited = new int[Y+1][X+1];
		
		for(int i = 1; i < Y+1; i++) {
			String str = br.readLine();
			for(int j = 1; j < X+1; j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		bfs(1, 1);
		
		sb.append(visited[Y][X]);
		System.out.println(sb);
	}
	
}