package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex6588sol2 {
	// 07 : 41
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] isPrime = new boolean[1000001];
		
		for(int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) continue;
			for(int j = i + i; j < isPrime.length; j += i) {
				isPrime[j] = true;
			}
		}
		
		int num = Integer.parseInt(br.readLine());
		while(num != 0) {
			boolean canDo = false;
			for(int i = 3; i < num; i++) {
				if(!isPrime[i] && !isPrime[num-i]) {
					sb.append(num + " = ").append(i + " + ").append(num-i).append('\n');
					canDo = true;
					break;
				}
			}
			
			if(!canDo) sb.append("Goldbach's conjecture is wrong.");
			
			num = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
		
	}
	
}