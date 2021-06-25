package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1676sol2 {
	// 10 : 05
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 5; i <= tc; i += 5) {
			int num = i;
			while(num%5 == 0) {
				cnt++;
				num /= 5;
			}
			
		}
		
		sb.append(cnt);
		
		System.out.println(sb);
		
	}
	
}