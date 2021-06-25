package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2751 {
	// 7 : 52
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int[] ary = new int[tc];
		int[] cnt = new int[2000003];
		
		for(int i = 0; i < tc; i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < ary.length; i++) {
			cnt[ary[i] + 1000000]++;
		}
		
		for(int i = 0; i < 2000003; i++) {
			for(int j = 0; j < cnt[i]; j++) {
				sb.append((i-1000000)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}