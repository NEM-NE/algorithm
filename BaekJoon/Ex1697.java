import java.io.*;
import java.util.*;


public class Ex1697 {
	
	static int min;
	static boolean[] visited;
	
	static void bfs(int cur, int goal) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0;
		queue.offer(cur);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int num = queue.poll();
				
				if(num == goal) {
					min = Math.min(min, cnt);
				}
				
				if((num+1) >= 0 && (num+1) <= 100000 && !visited[num + 1]) {
					visited[num + 1] = true;
					queue.offer(num + 1);
				}
				
				if((num-1) >= 0 && (num-1) <= 100000 &&!visited[num - 1]) {
					visited[num - 1] = true;
					queue.offer(num - 1);
				}
				
				if((2 * num) >= 0 && (2 * num) <= 100000 && !visited[num * 2]) {
					visited[num * 2] = true;
					queue.offer(num * 2);
				}
			}
			
			cnt++;
			
		}
	}
	
	// 6 : 28 43min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cur = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		min = Math.abs(goal - cur);
		visited = new boolean[100001];
		
		bfs(cur, goal);
		
		sb.append(min);
		System.out.println(sb);
	}

}
