import java.io.*;
import java.util.*;


public class Main {

	static boolean[] visited;
	static int min;
	
	static void bfs(int cur, int goal) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(cur);
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int num = queue.poll();
				
				if(num == goal) {
					min = Math.min(min, cnt);
					return;
				}
				
				if(num > 100001 || num < 0) continue;
				if(visited[num]) continue;
				
				visited[num] = true;
				
				if(num + 1 <= 100000) {
					queue.offer(num + 1);
				}
				
				if(num - 1 >= 0) {
					queue.offer(num - 1);
				}
				
				if(num * 2 <= 100000) {
					queue.offer(num * 2);
				}
				
			}
			
			cnt++;
		}
	}
	
	// 9 : 15 15min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cur = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		
		min = Math.abs(goal - cur);
		
		bfs(cur, goal);
		
		sb.append(min);
		
		System.out.println(sb);
	}

}
