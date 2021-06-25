package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10820 {
	// 7 : 02
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(scanner.hasNextLine()) {
			int[] cnt = new int[4]; //lower, upper, num, whitespace
			String str = scanner.nextLine();
			
			for(int i = 0; i < str.length(); i++) {
				char a = str.charAt(i);
				
				if(a >= 'a' && a <= 'z') cnt[0]++;
				else if(a >= 'A' && a <= 'Z') cnt[1]++;
				else if(a >= '0' && a <= '9') cnt[2]++;
				else cnt[3]++;
			}
			System.out.println(cnt[0] + " " + cnt[1] + " " + cnt[2] + " " + cnt[3]);
			
		}
		
	}
}