import java.io.*;
import java.util.*;


public class Main {
	
	static boolean[] isNotPrime;
	static boolean[] visited;
	
	static int bfs(int cur, int goal) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[cur] = true;
		queue.offer(cur);
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			for(int i = 0; i < n; i++) {
				int temp = queue.poll();
				String num = temp + "";
				
				if(temp == goal) {
					return cnt;
				}
				
				for(int j = 1; j <10; j++) {
					String str = j + num.substring(1, 4);
					int k = Integer.parseInt(str);
					if(!isNotPrime[k] && !visited[k]) {
						visited[k] = true;
						queue.offer(k);
					}
				}
				
				for(int j = 0; j <10; j++) {
					String str = num.substring(0, 1) + j + num.substring(2, 4);
					int k = Integer.parseInt(str);
					if(!isNotPrime[k] && !visited[k]) {
						visited[k] = true;
						queue.offer(k);
					}
				}
				
				for(int j = 0; j <10; j++) {
					String str = num.substring(0, 2) + j + num.substring(3, 4);
					int k = Integer.parseInt(str);
					if(!isNotPrime[k] && !visited[k]) {
						visited[k] = true;
						queue.offer(k);
					}
				}
				
				for(int j = 0; j <10; j++) {
					String str = num.substring(0, 3) + j;
					int k = Integer.parseInt(str);
					if(!isNotPrime[k] && !visited[k]) {
						visited[k] = true;
						queue.offer(k);
					}
				}
			}
			
			cnt++;
		}
		
		return -1;
	}
	
	//  9 : 41 37min 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		isNotPrime = new boolean[10000];
		
		for(int i = 2; i < 10000; i++) {
			if(isNotPrime[i]) continue;
			
			for(int j = i + i; j < 10000; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		int size = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			
			int cnt = bfs(cur, goal);
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}

}
