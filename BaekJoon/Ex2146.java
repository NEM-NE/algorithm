package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2146 {
	// 07 : 13 8
	
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, number, min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static Queue<Node> que;
	
	static int findShortest(int x, int y) {
		que.offer(new Node(x, y));
		visited[y][x] = true;
		
		int cnt = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int k = 0; k < size; k++) {
				Node node = que.poll();
				
				if(map[node.y][node.x] != map[y][x] && map[node.y][node.x] != 0) {
					return cnt;
				}
				
				for(int i = 0; i < 4; i++) {
					int xx = node.x + dx[i];
					int yy = node.y + dy[i];
					
					if(xx > 0 && xx < N+1 && yy > 0 && yy < N+1) {
						if(!visited[yy][xx] && map[yy][xx] != map[y][x]) {
							que.offer(new Node(xx, yy));
							visited[yy][xx] = true;
						}
					}
				}	
			}
			cnt++;
		}
		
		return Integer.MAX_VALUE;
	}
	
	static void numbering(int x, int y) {
		que.offer(new Node(x, y));
		visited[y][x] = true;
		map[y][x] = number;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];
				
				if(xx > 0 && xx < N+1 && yy > 0 && yy < N+1) {
					if(!visited[yy][xx] && map[yy][xx] == 1) {
						que.offer(new Node(xx, yy));
						visited[yy][xx] = true;
						map[yy][xx] = number;
					}
				}
			}	
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		min = Integer.MAX_VALUE;
		que = new LinkedList<Ex2146.Node>();
		
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		number = 2;
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				if(map[i][j] == 1) {
					que.clear();
					numbering(j, i);
					number++;
				}
			}
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				if(map[i][j] > 1) {
					que.clear();
					visited = new boolean[N+1][N+1];
					min = Math.min(findShortest(j, i), min);
				}
			}
		}
		
		
		sb.append(min-1);
		System.out.println(sb);

	}

}