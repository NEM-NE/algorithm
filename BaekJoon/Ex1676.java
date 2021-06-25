package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1676 {
	// 11 : 41
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int a = num % 5;
		num -= a;
		for(int j = 5; j <= num; j+=5) {
			int b = j;
			while((b/5)%5 == 0) {
				cnt++;
				b /= 5;
			}
		}
		cnt += num/5;
		
		sb.append(cnt);
		System.out.println(sb);
	}
	
	

}