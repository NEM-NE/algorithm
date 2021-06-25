package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10815 {
	// 8 :15
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] ary = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ary);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int index = Integer.parseInt(st.nextToken());
			int max = n-1;
			int min = 0;
			int cnt = 0;
			while(min <= max) {
				int mid = (max + min) / 2;
				
				if(ary[mid] == index) {
					cnt++;
					break;
				}
				
				if(ary[mid] > index) {
					max = mid - 1;
				}else {
					min = mid + 1;
				}
			}
			
			sb.append(cnt + " ");
		
		}
	
		System.out.println(sb);
		
	}

}