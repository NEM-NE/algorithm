import java.io.*;
import java.util.*;


public class Main {
	
	static int[][] map;
	
	static int cal(int x, int y) {
		int sum = 0;
		
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				sum += map[i][j];
			}
		}
		
		return sum;
	}
	
	// 3 : 00
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		long max = 0;
		
		// input
		map = new int[y][x];
		for(int i = 0; i < y; i++) {
			String str = br.readLine();
			for(int j = 0; j < x; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		//case 1
		for(int i = 0; i < x; i++) {
			long case1 = cal(i, y);
			for(int j = i+1; j < x; j++) {
				long case2 = cal(j, y) - case1;
				long case3 = cal(x, y) - case1 - case2;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		//case 2
		for(int i = 0; i < y; i++) {
			long case1 = cal(x, i);
			for(int j = i+1; j < y; j++) {
				long case2 = cal(x, j) - case1;
				long case3 = cal(x, y) - case1 - case2;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		//case 3
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				long case1 = cal(j, y);
				long case2 = cal(x, i) - cal(j, i);
				long case3 = cal(x, y) - case1 - case2;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		//case 4
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				long case1 = cal(j, i);
				long case2 = cal(j, y) - case1;
				long case3 = cal(x, y) - case2 - case1;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		//case 5
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				long case1 = cal(x, i);
				long case2 = cal(j, y) - cal(j, i);
				long case3 = cal(x, y) - case1 - case2;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		//case 6
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				long case1 = cal(j, i);
				long case2 = cal(x, i) - cal(j, i);
				long case3 = cal(x, y) - case1 - case2;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		sb.append(max);
		System.out.println(sb);
	}

}
