package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2805sol2 {
	// 5 : 13
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[n];
		int max = 0;
		int min = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(tree[i], max);
		}
		
		while(min <= max) {
			int mid = (max + min) / 2;
			
			long sum = 0;
			for(int i = 0; i < n; i++) {
				if(tree[i] > mid) sum += tree[i] - mid;
			}
			
			if(sum < k) {
				max = mid - 1;
			}else {
				min = mid + 1;
			}
		}
		
		sb.append(max);
		System.out.println(sb);
		
		

	}

}