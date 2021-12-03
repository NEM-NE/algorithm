import java.io.*;
import java.util.*;


public class Ex10971sol3 {
	
	static int[][] map;
	static int min;
	
	static int cal(int[] ary) {
		int sum = 0;
		
		for(int i = 0; i < ary.length-1; i++) {
			int a = map[ary[i]][ary[i+1]];
			
			if(a == 0) return Integer.MAX_VALUE;
			
			sum += a;
		}
		
		if(map[ary[ary.length-1]][ary[0]] == 0) return Integer.MAX_VALUE;
		
		return sum + map[ary[ary.length-1]][ary[0]]; 
	}
	
	static void permutation(int[] ary, int depth, int n, int r) {
		if(depth == r) {
			min = Math.min(min, cal(ary));
			return;
		}
		
		for(int i = depth; i < n; i++) {
			swap(ary, depth, i);
			permutation(ary, depth + 1, n, r);
			swap(ary, depth, i);
		}
	}
	
	static void swap(int[] ary, int i, int j) {
		int temp = ary[i];
		ary[i] = ary[j];
		ary[j] = temp;
	}
	
	// 11 : 30 13min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		
		map = new int[size][size];
		int[] ary = new int[size];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ary[i] = i;
			for(int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutation(ary, 0, size, size);
		
		sb.append(min);
		
		System.out.println(sb);
		
	}

}
