import java.io.*;
import java.util.*;


public class Ex10819 {
	static int max = 0;
	
	static void permutation(int[] arr, int depth, int n, int r) {
	    if (depth == r) {
	        cal(arr);
	        return;
	    }
	 
	    for (int i=depth; i<n; i++) {
	        swap(arr, depth, i);
	        permutation(arr, depth + 1, n, r);
	        swap(arr, depth, i);
	    }
	}
	 
	static void swap(int[] arr, int depth, int i) {
	    int temp = arr[depth];
	    arr[depth] = arr[i];
	    arr[i] = temp;
	}
	
	static void cal(int[] list) {
		int sum = 0;
		for(int i = 0; i < list.length-1; i++) {
			sum += Math.abs(list[i] - list[i+1]);
		}
		
		max = Math.max(max, sum);
	}
	
	// 6 : 32 57min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		int[] list = new int[tc];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < tc; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(list, 0, tc, tc);
		
		sb.append(max);
		System.out.println(sb);
		
	}

}
