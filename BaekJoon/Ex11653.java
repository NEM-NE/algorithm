package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11653 {
	// 11 : 17
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] isPrime = new boolean[10000001];
		
		for(int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) continue;
			int index = i + i;
			while(index < isPrime.length) {
				isPrime[index] = true;
				index += i;
			}
		}
		
		int num = Integer.parseInt(br.readLine());
		int i = 2;
		while(num != 1) {
			if(!isPrime[i] && num%i == 0) {
				num /= i;
				sb.append(i).append('\n');
			}else {
				i++;
			}

		}
		
		System.out.println(sb);

		
	}
	

}