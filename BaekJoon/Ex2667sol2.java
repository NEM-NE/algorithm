package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2667sol2 {
	// 10 : 39
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] map;
	static boolean[][] visited;
	static int[] aryX = {0, 1, 0, -1};
	static int[] aryY = {-1, 0, 1, 0}; 
	static int cnt;
	static int tc;
	
	static void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(x, y));
		visited[x][y] = true;
		cnt++;
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = node.x + aryX[i];
				int yy = node.y + aryY[i];
				
				if(xx > 0 && xx < map.length && yy > 0 && yy < map.length) {
					if(map[xx][yy] == 1 && !visited[xx][yy]) {
						Node no = new Node(xx, yy);
						que.offer(no);
						visited[xx][yy] = true;
						cnt++;
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		tc = Integer.parseInt(br.readLine());
		
		map = new int[tc+1][tc+1];
		visited = new boolean[tc+1][tc+1];
		
		for(int i = 1; i <= tc; i++) {
			String str = br.readLine();
			
			for(int j = 1; j <= str.length(); j++) {
				int num = str.charAt(j-1) - '0';
				
				if(num == 1) {
					map[j][i] = num;
				}
			}			
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= tc; i++) {
			for(int j = 1; j <= tc; j++) {
				if(map[j][i] == 1 && !visited[j][i]) {
					cnt = 0;
					bfs(j, i);
					list.add(cnt);	
				}
			}
		}
		
		list.sort(null);
		sb.append(list.size()).append('\n');
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
}