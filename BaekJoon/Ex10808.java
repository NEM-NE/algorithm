package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10808 {
	// 6 : 46
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int[] ary = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			ary[a - 'a']++;
		}
		
		for(int i = 0; i < ary.length; i++) {
			sb.append(ary[i]).append(" ");
		}
		
		System.out.println(sb);
		
		
	}
}