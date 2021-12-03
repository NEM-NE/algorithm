import java.io.*;
import java.util.*;


public class Ex10971 {
	
	static int min;
	static int[][] map;
	
	static int cal(int[] arr) {
		int sum = 0;
		int cur = -1;
		int next = -1;
		
		for(int i = 0; i < arr.length-1; i++) {
			cur = arr[i];
			next = arr[i+1];
			
			if(map[cur][next] == 0) {	//지나갈 수 없는 길을 지난 경우
				return Integer.MAX_VALUE;
			}
			
			sum += map[cur][next];
		}
		
		if(map[next][arr[0]] == 0) {
			return Integer.MAX_VALUE;
		}
		
		return sum + map[next][arr[0]];		//되돌아 오는 경우
	}
	
	static void permutation(int[] arr, int depth, int n, int k) {
		if(depth == k) {
			min = Math.min(cal(arr), min);
			return;
		}
		
		for(int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth+1, n, k);
			swap(arr, depth, i);
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// 9 : 51 45min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		int[] indexAry = new int[size];
		map = new int[size][size];
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = null;
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}
		
		for(int i = 0; i < size; i++) {
			indexAry[i] = i;
		}
		
		permutation(indexAry, 0, size, size);
		
		if(min == Integer.MAX_VALUE) {
			sb.append(0);
		}else sb.append(min);
		
		System.out.println(sb);
	}

}
