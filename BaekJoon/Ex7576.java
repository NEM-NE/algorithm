package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex7576 {
	// 05 : 55
	
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int h, w;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static Queue<Node> que;
	static int[][] visited;
	
	static void bfs() {
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];
				
				if(xx > 0 && xx < w+1 && yy > 0 && yy < h+1) {
					if(map[yy][xx] == 0 && visited[yy][xx] == 0) {
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
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h+1][w+1];
		visited = new int[h+1][w+1];
		
		for(int i = 1; i < h+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < w+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		que = new LinkedList<Node>();
		for(int i = 1; i < h+1; i++) {
			for(int j = 1; j < w+1; j++) {
				if(map[i][j] == 1) {
					que.offer(new Node(j, i));
				}
			}
		}
		
		bfs();
		
		int max = 0;
		for(int i = 1; i < h+1; i++) {
			for(int j = 1; j < w+1; j++) {
				if(map[i][j] != 0) continue;
				if(max < visited[i][j]) max = visited[i][j];
				if(visited[i][j] == 0) {
					sb.append(-1);
					System.out.println(sb);
					return;
				}
			}
		}
		
		sb.append(max);
		System.out.println(sb);
		

	}

}