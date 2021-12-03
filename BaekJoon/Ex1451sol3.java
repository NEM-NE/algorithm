import java.io.*;
import java.util.*;


public class Ex1451sol3 {
	
	static int[][] map;
	
	static long sum(int x, int y) {
		long sum = 0;
		
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				sum += map[i][j];
			}
		}
		
		return sum;
	}
	
	//4 : 08  17min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		map = new int[y][x];
		for(int i = 0; i < y; i++) {
			String str = br.readLine();
			for(int j = 0; j < x; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		long max = 0;
		
		// case1
		for(int i = 0; i < x; i++) {
			long case1 = sum(i, y);
			for(int j = i+1; j < x; j++) {
				long case2 = sum(j, y) - case1;
				long case3 = sum(x, y) - case2 - case1;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		// case2
		for(int i = 0; i < y; i++) {
			long case1 = sum(x, i);
			for(int j = i+1; j < y; j++) {
				long case2 = sum(x, j) - case1;
				long case3 = sum(x, y) - case2 - case1;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		// case3
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				long case1 = sum(j, y);
				long case2 = sum(x, i) - sum(j, i);
				long case3 = sum(x, y) - case2 - case1;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}

		// case4
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				long case1 = sum(j, i);
				long case2 = sum(j, y) - case1;
				long case3 = sum(x, y) - case2 - case1;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		// case5
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				long case1 = sum(x, i);
				long case2 = sum(j, y) - sum(j, i);
				long case3 = sum(x, y) - case2 - case1;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		// case6
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				long case1 = sum(j, i);
				long case2 = sum(x, i) - sum(j, i);
				long case3 = sum(x, y) - case2 - case1;
				
				max = Math.max(max, case1 * case2 * case3);
			}
		}
		
		sb.append(max);
		System.out.println(sb);
	}

}
