package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10989 {
	// 07 : 52

	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int[] ary = new int[tc];
		int[] cnt = new int[10001];
		
		for(int i = 0; i < tc; i++) {
			ary[i] = Integer.parseInt(br.readLine());
			cnt[ary[i]]++;
		}
		
		for(int i = 0; i < cnt.length; i++ ) {
			for(int j = 0; j < cnt[i]; j++) {
				sb.append(i).append('\n');
			}
		}
		
		System.out.println(sb);
	
		
	}
}