package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2146sol2 {
	// 1 : 29
	
	static class Node{
		int x, y, cnt;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int number, min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void findShortest(int x, int y, int number) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y));
		visited[y][x] = true;

		while(!que.isEmpty()) {
			Node node = que.poll();
		
			for(int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];
				
				if(xx <= 0 || xx >= map.length || yy <= 0 || yy >= map.length) continue;
				if(visited[yy][xx] || map[yy][xx] == number) continue;
				
				if(map[yy][xx] == 0){
					Node no = new Node(xx, yy);
					no.cnt = node.cnt + 1;
					que.offer(no);
					visited[yy][xx] = true;
				}else if(map[yy][xx] != number) {
					min = Math.min(min, node.cnt);
					return;
				}
			}
			
		}
		
	}
	
	static void numbering(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y));
		visited[y][x] = true;
		map[y][x] = number;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
		
			for(int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];
				
				if(xx > 0 && xx < map.length && yy > 0 && yy < map.length) {
					if(!visited[yy][xx] && map[yy][xx] != 0) {
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
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		map = new int[tc+1][tc+1];
		visited = new boolean[tc+1][tc+1];
		
		for(int i = 1; i < tc+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < tc+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		number = 1;
		for(int i = 1; i < tc+1; i++) {
			for(int j = 1; j < tc+1; j++) {
				if(map[i][j] == 1) {
					number++;
					numbering(j, i);
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i = 1; i < tc+1; i++) {
			for(int j = 1; j < tc+1; j++) {
				if(map[i][j] > 1) {
					visited = new boolean[tc+1][tc+1];
					findShortest(j, i, map[i][j]);
				}
			}
		}
		
		sb.append(min);
		System.out.println(sb);
	}

}