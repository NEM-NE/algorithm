package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10816sol2 {
	// 5 : 15
	
	static int[] ary;
	
	static int upper_bound(int num) {
		int max = ary.length;
		int min = 0;
		
		while(min < max) {
			int mid = (max + min) / 2;
			
			if(ary[mid] <= num) {
				min = mid + 1;
			}else {
				max = mid;
			}
		}
		
		return max;
	}
	
	static int lower_bound(int num) {
		int max = ary.length;
		int min = 0;
		
		while(min < max) {
			int mid = (max + min) / 2;
			
			if(ary[mid] < num) {
				min = mid + 1;
			}else {
				max = mid;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		ary = new int[tc];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < tc; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ary);
		
		tc = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < tc; i++) {
			int n = Integer.parseInt(st.nextToken());
			int lo = lower_bound(n);
			int hi = upper_bound(n);

			sb.append(hi - lo).append(" ");
		}
		
		System.out.println(sb);
	}

}