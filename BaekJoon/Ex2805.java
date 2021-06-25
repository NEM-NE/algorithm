package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2805 {
	// 10 : 20
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1000000000;
		int min = 0;
		int ans = 0;
		while((min+1) < max) {
			int mid = (max + min) / 2;
			
			long sum = 0;
			for(int i = 0; i < n; i++) {
				if(trees[i] > mid) sum += trees[i] - mid;
			}
			
			if(sum == m) {
				ans = mid;
				break;
			}
			
			if(sum > m) {
				min = mid;
				ans = mid;
			}else {
				max = mid;
			}
		}
		sb.append(ans);
		System.out.println(sb);
		
	}

}