package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1676sol3 {
	// 11 : 37
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(tc >= 5) {
			cnt += tc/5;
			tc /= 5;
		}
		
		sb.append(cnt);
		System.out.println(sb);
	}
	
}