package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10825 {
	// 07 : 03

	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int tc = scanner.nextInt();
		String[][] ary = new String[tc][4];
		
		for(int i = 0; i < tc; i++) {
			ary[i][0] = scanner.next();	//name
			ary[i][1] = scanner.next();	// korea
			ary[i][2] = scanner.next(); // english
			ary[i][3] = scanner.next(); // math
		}
		
		Arrays.sort(ary, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				int k1 = Integer.parseInt(o1[1]);
				int k2 = Integer.parseInt(o2[1]);
				int e1 = Integer.parseInt(o1[2]);
				int e2 = Integer.parseInt(o2[2]);
				int m1 = Integer.parseInt(o1[3]);
				int m2 = Integer.parseInt(o2[3]);
				
				if(k1 == k2 && e1 == e2 && m1 == m2) {
					return o1[0].compareTo(o2[0]);
				}else if(k1 == k2 && e1 == e2) {
					return m2 - m1;
				}else if(k1 == k2) {
					return e1 - e2;
				}else {
					return k2 - k1;
				}
				
			}
		});
		
		for(int i = 0; i < tc; i++) {
			sb.append(ary[i][0]).append('\n');
		}
		
		System.out.println(sb);
	}
}