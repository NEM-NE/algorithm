package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1978 {
	// 11 : 07
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] isPrime = new boolean[1001];
		
		for(int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		
		for(int i = 2; i < isPrime.length; i++) {
			if(!isPrime[i]) continue;
			int num = i + i;
			while(num < isPrime.length) {
				isPrime[num] = false;
				num += i;
			}
		}
		
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i = 0; i < tc; i++) {
			int index = Integer.parseInt(st.nextToken());
			if(isPrime[index]) cnt++;
		}
		
		sb.append(cnt);
		System.out.println(sb);
		
	}
	

}