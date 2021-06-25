import java.util.*;

import javax.sound.sampled.ReverbType;

import java.io.*;


public class Main {
	
	
	// 11 : 29
	/*
	 * 4분
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		if(!str.contains("0")) {
			System.out.println(-1);
			return;
		}
		
		char[] ary = str.toCharArray();
		
		Arrays.sort(ary);
		
		long sum = 0;
		for(int i = ary.length-1; i >= 0; i--) {
			sum += ary[i] - '0';
			sb.append(ary[i] - '0');
		}
		
		if(sum % 3 != 0) {
			System.out.println(-1);
			return;
		}else {
			System.out.println(sb);
		}
		
	}

}
