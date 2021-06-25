package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1929 {
	// 11 : 21
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] isPrime = new boolean[1000001];
		
		for(int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		
		for(int i = 2; i < isPrime.length; i++) {
			if(!isPrime[i]) continue;
			int num = i+i;
			
			while(num < isPrime.length) {
				isPrime[num] = false;
				num += i;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = n; i <= m; i++) {
			if(isPrime[i]) sb.append(i).append('\n');
		}
		
		System.out.println(sb);
	}
	

}