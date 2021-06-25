package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1373sol2 {
	// 3 : 25	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		int index = str.length();
		while(index > 0) {
			String des = "";
			if(index < 2) {
				des = str.substring(index-1, index);
			}else if(index < 3) {
				des = str.substring(index-2, index);
			}else {
				des = str.substring(index-3, index);
			}
			
			
			int num = 0;
			for(int i = 0; i < des.length(); i++) {
				int input = (int)(des.charAt(i) - '0');
				num += input * Math.pow(2, des.length()-i-1);
			}
			sb.append(num);
			index -= 3;
		}
		
		sb.reverse();
		System.out.println(sb);

	}
	

}