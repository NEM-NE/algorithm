package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2089 {
	// 9 : 57
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		
		if(num == 0) {
			System.out.println(num);
			System.exit(0);
		}
		
		while(num != 0) {
			int k = Math.abs(num%-2);
			sb.append(k);
			num = (int) Math.ceil((double)num/-2);
		}
		
		sb.reverse();
		System.out.println(sb);
			

	}
	

}