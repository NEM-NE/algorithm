import java.io.*;
import java.util.*;


public class Ex9019 {
	
	static class Register {
		int num;
		String operation;
		
		public Register(int num, String str) {
			this.num = num;
			this.operation = str;
		}
	}
	
	static boolean[] visited;
	
	static String bfs(int cur, int goal) {
		Queue<Register> queue = new LinkedList<Register>();
		queue.offer(new Register(cur, ""));
		visited[cur] = true;
		
		while(!queue.isEmpty()) {
			Register regis = queue.poll();
			
			if(goal == regis.num) {
				return regis.operation;
			}
			
			String oper = regis.operation;
			
			// case : D
			int num = regis.num * 2;
			if(num > 9999) num = num%10000;
			if(!visited[num]) {
				queue.offer(new Register(num, oper + "D"));
			}
			
			// case : S
			num = regis.num - 1;
			if(num == -1) num = 9999;
			if(!visited[num]) {
				queue.offer(new Register(num, oper + "S"));
			}
			
			// case : L
			String str = regis.num + "";
			num =  Integer.parseInt(str.substring(1, str.length()) + str.charAt(0));
			if(!visited[num]) {
				queue.offer(new Register(num, oper + "L"));
			}
			
			// case : L
			str = regis.num + "";
			num =  Integer.parseInt(str.charAt(str.length()-1) + str.substring(0, str.length()-1));
			if(!visited[num]) {
				queue.offer(new Register(num, oper + "D"));
			}
			
		}
		
		return "IMPOSIBLE";
	}
	
	//10 : 36  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < size; i++) {
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
