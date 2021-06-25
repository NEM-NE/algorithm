package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11052sol2 {
	// 06 : 33

	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int tc = scanner.nextInt();
		int[][] ary = new int[tc][2];
		
		for(int i = 0; i < tc; i++) {
			ary[i][0] = scanner.nextInt();
			ary[i][1] = scanner.nextInt();
		}
		
		Arrays.sort(ary, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}
			
		});
		
		for(int i = 0; i < tc; i++) {
			sb.append(ary[i][0] + " " + ary[i][1]).append('\n');
		}
		
		System.out.println(sb);
	}
}