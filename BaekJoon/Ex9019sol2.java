import java.io.*;
import java.util.*;


public class Ex9019sol2 {
	
	static class Register {
		int num;
		String oper;
		
		public Register(int num) {
			this.num = num;
			this.oper = "";
		}
	}
	
	static boolean[] visited;
	
	static String bfs(int cur, int goal) {
		Queue<Register> queue = new LinkedList<Register>();
		queue.offer(new Register(cur));
		
		while(!queue.isEmpty()) {
			Register regis = queue.poll();
			
			if(visited[regis.num]) {
				continue;
			}
			
			if(regis.num == goal) {
				return regis.oper;
			}
			
			visited[regis.num] = true;
			
			//case D
			int num = (regis.num * 2) % 10000;
			Register temp = new Register(num);
			temp.oper = regis.oper + "D";
			
			queue.offer(temp);
			
			//case S
			num = (regis.num == 0) ? 9999 : regis.num - 1;
			temp = new Register(num);
			temp.oper = regis.oper + "S";
			
			queue.offer(temp);
			
			//case L
			int a = regis.num / 1000;
			int b = regis.num % 1000;
			num = b * 10 + a;
			temp = new Register(num);
			temp.oper = regis.oper + "L";
			
			queue.offer(temp);
			
			//case R
			a = regis.num / 10;
			b = regis.num % 10;
			num = b * 1000 + a;
			temp = new Register(num);
			temp.oper = regis.oper + "R";
			
			queue.offer(temp);
			
		}
		
		return "IMPOSIBLE";
	}
	
	// 03 : 02 38min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());
		for(int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int cur = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			
			String ans = bfs(cur, goal);
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	
	}

}
