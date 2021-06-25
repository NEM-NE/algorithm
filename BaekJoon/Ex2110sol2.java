package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2110sol2 {
	// 8 : 00
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n];
		
		for(int i = 0; i < n; i++) {
			dist[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(dist);
		
		int max = dist[n-1];
		int min = 0;
		
		while(min <= max) {
			int mid = (min + max) / 2;
			int cnt = 1;
			int len = dist[0] + mid;
			for(int i = 0; i < n; i++) {
				if(len <= dist[i]) {
					len = dist[i] + mid;
					cnt++;
				}
			}
			
			if(cnt < c) {
				max = mid - 1;
			}else {
				min = mid + 1;
			}
		}
		
		System.out.println(max);

	}

}