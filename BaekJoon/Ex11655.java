package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11655 {
	// 7 : 24
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String ans = "";
		for(int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if(a >= 'a' && a <= 'z') {
				int num = a - 'a';
				num = (num + 13) % 26;
				a = (char) (num + 'a');
			}else if(a >= 'A' && a <= 'Z') {
				int num = a - 'A';
				num = (num + 13) % 26;
				a = (char) (num + 'A');
			}
			ans += a;
		}
		
		sb.append(ans);
		
		System.out.println(sb);
		
	}
}