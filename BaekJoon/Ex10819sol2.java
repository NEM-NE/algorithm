import java.io.*;
import java.util.*;


public class Ex10819sol2 {
	static int max;
	
	static int cal(int[] ary) {
		int sum = 0;
		for(int i = 0; i < ary.length - 1; i++) {
			sum += Math.abs(ary[i] - ary[i + 1]);
		}
		
		return sum;
	}
	
	static void permutation(int[] ary, int depth, int n, int r) {
		if(depth == r) {
			
			max = Math.max(max, cal(ary));
			
			return;
		}
		
		for(int i = depth; i < n; i++) {
			swap(ary, depth, i);
			permutation(ary, depth+1, n, r);
			swap(ary, depth, i);
		}
	}
	
	static void swap(int[] ary, int i, int j) {
		int temp = ary[i];
		ary[i] = ary[j];
		ary[j] = temp;
	}
	
	// 2 : 26 5min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		max = 0;
		int[] ary = new int[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < ary.length; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(ary, 0, size, size);
		
		sb.append(max);
		System.out.println(sb);
	}

}
