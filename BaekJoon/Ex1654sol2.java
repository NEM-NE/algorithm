package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1654sol2 {
	// 12 : 50
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[] list = new long[k];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		long max = Integer.MAX_VALUE;
		long min = 0;

		while((min+1) < max) {
			long mid = (max + min) / 2;
			
			long sum = 0;
			for(int i = 0; i < k; i++) {
				if(list[i] >= mid) sum += list[i]/mid;
			}
			
			if(sum >= n) {
				min = mid;
			}else {
				max = mid;
			}
		}
		
		long sum = 0, sum1 = 0;
		for(int i = 0; i < k; i++) {
			if(list[i] >= max) sum += list[i]/max;
			if(list[i] >= min) sum1 += list[i]/min;
		}

		if(sum >= n)sb.append(max);
		else if(sum1 >= n) sb.append(min);
		
		System.out.println(sb);
	}

}