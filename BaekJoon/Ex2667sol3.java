import java.util.*;
import java.io.*;


public class Main {
	
	static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int cnt = 0;
	static int sum = 0;
	
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();
		visited[y][x] = true;
		queue.offer(new Node(x, y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];
				
				if(xx < 0 || xx >= map.length || yy < 0 || yy >= map.length) continue;
				if(!visited[yy][xx] && map[yy][xx] != 0) {
					visited[yy][xx] = true;
					queue.offer(new Node(xx, yy));
					cnt++;
				}
			}
		}
	}
	
	// 7 : 42 20분
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				int num = str.charAt(j) - '0';
				map[i][j] = num;
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int num = map[i][j];
				if(num != 0 && !visited[i][j]) {
					cnt = 1;
					sum++;
					bfs(j, i);
					ans.add(cnt);
				}
			}
		}
		Collections.sort(ans);
		sb.append(sum).append('\n');
		for(int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)).append('\n');
		}
		
		System.out.println(sb);
	}

}
