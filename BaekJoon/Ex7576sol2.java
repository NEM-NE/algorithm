import java.util.*;
import java.io.*;


public class Ex7576sol2 {
	
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
	static int cnt = 2;

	static void bfs() {		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int k = 0; k < size; k++) {
				Node node = queue.poll();
				visited[node.y][node.x] = true;
				
				for(int i = 0; i < 4; i++) {
					int xx = node.x + dx[i];
					int yy = node.y + dy[i];
					
					if(xx < 0 || xx >= map[0].length || yy < 0 || yy >= map.length) continue;
					if(!visited[yy][xx] && map[yy][xx] == 0) {
						visited[yy][xx] = true;
						map[yy][xx] = cnt;
						queue.offer(new Node(xx, yy));
					}
				}
			}
			
			cnt++;
		}
	}
	
	// 7 : 42 30min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		map = new int[y][x];
		visited = new boolean[y][x];
		queue = new LinkedList<Node>();
		
		for(int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				int num = map[i][j];
				if(num == 1) {
					queue.offer(new Node(j, i));
				}
			}
		}
		
		bfs();
		
		int max = 0;
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				
				if(max < map[i][j]) max = map[i][j];
			}
		}
		
		sb.append(max-1);
		System.out.println(sb);
	}

}
