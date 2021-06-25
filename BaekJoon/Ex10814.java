package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10814 {
	// 06 : 40

	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int tc = scanner.nextInt();
		String[][] ary = new String[tc][3];
		
		for(int i = 0; i < ary.length; i++) {
			ary[i][0] = i + "";
			ary[i][1] = scanner.next();
			ary[i][2] = scanner.next();
		}
		
		Arrays.sort(ary, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				int a = Integer.parseInt(o1[1]);
				int b = Integer.parseInt(o2[1]);
				
				if(a == b) {
					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
				}else {
					return a - b;
				}
			}
			
		});
		
		for(int i = 0; i < tc; i++) {
			sb.append(ary[i][1] + " " + ary[i][2]).append('\n');
		}
		
		System.out.println(sb);
		
	}
}