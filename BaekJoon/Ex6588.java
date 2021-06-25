package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex6588 {
	// 10 : 29
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean[] isPrime = new boolean[1000000];
		
		for(int i = 3; i < isPrime.length; i+=2 ) {
			isPrime[i] = true;
		}
		
		for(int i = 3; i < isPrime.length; i+=2 ) {
			if(!isPrime[i]) continue;
			int index = 3*i;
			while(index < isPrime.length) {
				isPrime[index] = false;
				index += i+i;
			}
		}
		
		while(scanner.hasNext()) {
			int num = scanner.nextInt();
			if(num == 0) break;
			
			int a = 0;
			int b = 0;
			for(int i = 3; i < num; i++) {
				if(isPrime[i] && isPrime[num-i]) {
					a = i;
					b = num-i;
					break;
				}
			}
			
			if(a != 0) {
				sb.append(num + " = ").append(a + " + ").append(b).append('\n');
			}else {
				sb.append("Goldbach's conjecture is wrong.").append('\n');
			}
			
		}
		
		System.out.println(sb);
		
		
	}
	

}