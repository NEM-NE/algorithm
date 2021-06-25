package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10820sol2 {
	// 10 : 42
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			StringBuilder sb = new StringBuilder();
			String que = scanner.nextLine();
			int[] cnt = new int[4];
			
			for(int i = 0; i < que.length(); i++) {
				char a = que.charAt(i);
				
				if(a >= 'a' && a <= 'z') {
					cnt[0]++;
				}else if(a >= 'A' && a <= 'Z') {
					cnt[1]++;
				}else if(a >= '0' && a <= '9') {
					cnt[2]++;
				}else {
					cnt[3]++;
				}
			}
			
			
			sb.append(cnt[0] + " ").append(cnt[1] + " ").append(cnt[2] + " ").append(cnt[3] + " ");
			System.out.println(sb);
		}
		

		
	}
}