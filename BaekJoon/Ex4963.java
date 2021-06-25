package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex4963 {
	// 11 : 06

	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y));
		visited[y][x] = true;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for(int i = 0; i < 8; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];

				if(xx > 0 && xx <= w && yy > 0 && yy <= h) {
					if(map[yy][xx] == 1 && !visited[yy][xx]) {
						que.offer(new Node(xx, yy));
						visited[yy][xx] = true;
					}
				}
			}
		}

	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0 0")) break;
			st = new StringTokenizer(str);
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h+1][w+1];
			visited = new boolean[h+1][w+1];
			
			for(int i = 1; i < h+1; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j < w+1; j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						map[i][j] = 1;
					}
				}
			}
			
			int cnt = 0;
			for(int i = 1; i < w+1; i++) {
				for(int j = 1; j < h+1; j++) {
					if(map[j][i] == 1 && !visited[j][i]) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			
			sb.append(cnt).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
}