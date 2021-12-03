import java.util.*;
import java.io.*;


public class Ex2146sol3 {
	
	static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Queue<Node> queue;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	static int calDistance(int x, int y) {
		Queue<Node> queue= new LinkedList<Node>();
		visited[y][x] = true;
		queue.offer(new Node(x, y));
		int num = map[y][x];
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int k = 0; k < size; k++) {
				Node node = queue.poll();
				
				for(int i = 0; i < 4; i++) {
					int xx = node.x + dx[i];
					int yy = node.y + dy[i];
					
					if(xx < 0 || xx >= map.length || yy < 0 || yy >= map.length) continue;
					if(visited[yy][xx]) continue;
					
					if(map[yy][xx] == 0) {
						visited[yy][xx] = true;
						queue.offer(new Node(xx, yy));
					}else if(map[yy][xx] != num){	// 다른 섬 찾음
						return cnt;
					}
				}
			}
			
			cnt++;
		}
		
		return -1;
	}
	
	static void numbering(int x, int y, int number) {
		Queue<Node> queue= new LinkedList<Node>();
		visited[y][x] = true;
		map[y][x] = number;
		queue.offer(new Node(x, y));
			
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];
				
				if(xx < 0 || xx >= map.length || yy < 0 || yy >= map.length) continue;
				if(!visited[yy][xx] && map[yy][xx] == 1) {
					visited[yy][xx] = true;
					map[yy][xx] = number;
					queue.offer(new Node(xx, yy));
				}
			}
		}
	}
	
	// 11 : 01
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 번호 넣기
		int number = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int num = map[i][j];
				if(num == 1 && !visited[i][j]) {
					numbering(j, i, number);
					number++;
				}
			}
		}
		
		// 최단 거리 계산하기
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != 0) {
					visited = new boolean[n][n];
					int num = calDistance(j, i);
					if(num != -1) {
						min = Math.min(min, num);
					}
				}
			}
		}
		
		sb.append(min);
		System.out.println(sb);
	}

}
