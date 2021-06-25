package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1212 {
	// 12 : 38
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Character.getNumericValue('4');
		for(int i = str.length()-1; i >= 0 ; i--) {
			int input = str.charAt(i) - '0';
			int num = input;
			int a = input;
			
			while(input != 0) {
				num %= 2;
				sb.append(num);
				input /= 2;
				num = input;
			}
			
			if(a == 0) {
				sb.append(0);
			}
			
			if(a < 2 && i != 0) {
				sb.append(0);
				sb.append(0);
			}else if(a < 4 && i != 0) {
				sb.append(0);	
			}
			
		}
		
		sb.reverse();
		
		System.out.println(sb);
		
	}
	

}