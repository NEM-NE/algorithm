package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1654sol3 {
	// 5 : 512
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[] lans = new long[k];
		long max = 0;
		long min = 1;
		
		for(int i = 0; i < k; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			max = Math.max(lans[i], max);
		}
		
		long ans = 0;
		while(min <= max) {
			long mid = (max + min) / 2;
			
			long sum = 0;
			for(int i = 0; i < k; i++) {
				sum += lans[i] / mid;
			}
			
			if(sum < n) {
				max = mid - 1;
			}else {
				ans = Math.max(ans, min);
				min = mid + 1;
			}
		}
		
		System.out.println(max);

	}

}