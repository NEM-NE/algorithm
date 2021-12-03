import java.io.*;
import java.util.*;


public class Ex1963sol2 {
	
	static boolean[] isPrime;
	static boolean[] visited;
	
	static String bfs(int cur, int goal) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(cur);
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int num = queue.poll();
				String str = num + "";
				
				if(num == goal) {
					return cnt + "";
				}
				
				if(num < 0 || num > 9999) continue;
				if(visited[num]) continue;
				
				visited[num] = true;
				
				// 1000자리
				for(int j = 1; j < 10; j++) {
					int n = Integer.parseInt(j + str.substring(1, 4));
					if(isPrime[n]) queue.offer(n);
				}
				
				// 100자리
				for(int j = 0; j < 10; j++) {
					int n = Integer.parseInt(str.substring(0, 1) + j + str.substring(2, 4));
					if(isPrime[n]) queue.offer(n);
				}
				
				// 10자리
				for(int j = 0; j < 10; j++) {
					int n = Integer.parseInt(str.substring(0, 2) + j + str.substring(3, 4));
					if(isPrime[n]) queue.offer(n);
				}
				
				// 1리
				for(int j = 1; j < 10; j++) {
					int n = Integer.parseInt(str.substring(0, 3) + j);
					if(isPrime[n]) queue.offer(n);
				}
			}
			
			cnt++;
		}
		
		return "imposible";
	}
	
	// 9 : 32 15min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		isPrime = new boolean[10000];
		
		Arrays.fill(isPrime, true);
		
		for(int i = 2; i < isPrime.length; i++) {
			if(!isPrime[i]) continue;
			for(int j = i + i; j < isPrime.length; j += i) {
				isPrime[j] = false;
			}
		}
		
		StringTokenizer st = null;
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			int cur = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			
			String ans = bfs(cur, goal);
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
		
	}

}
