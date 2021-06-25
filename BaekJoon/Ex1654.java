package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1654 {
	// 11 : 12
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] lans = new int[size];
		
		for(int i = 0; i < lans.length; i++) {
			lans[i] = Integer.parseInt(br.readLine());
		}
		long max = Integer.MAX_VALUE;
		long min = 0;
		
		while((min + 1) < max) {
			long mid = (max + min) / 2;
			
			int sum = 0;
			for(int i = 0; i < lans.length; i++) {
				if((lans[i] / mid) > 0) sum += lans[i] / mid;
			}
			
			if(sum < n) {
				max = mid;
			}else {
				min = mid;
			}
		}
		
		int sum = 0;
		int sum2 = 0;
		for(int i = 0; i < lans.length; i++) {
			if((lans[i] / min) > 0) sum += lans[i] / min;
			if((lans[i] / (min+1)) > 0) sum2 += lans[i] / (min+1);
		}
		
		if(sum > sum2) sb.append(min);
		else sb.append(min+1);
		
		System.out.println(sb);
		
	}

}