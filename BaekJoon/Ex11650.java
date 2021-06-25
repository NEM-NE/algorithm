package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11650 {
	// 10 : 44
		
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		int[][]ary = new int[tc][2];
		
		for(int i = 0; i < tc; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ary[i][0] = a;
			ary[i][1] = b;
		}
		
		Arrays.sort(ary, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			}else {
				return e1[0] - e2[0];
			}
		});
		
//		Arrays.sort(ary, new Comparator<int[]>(){
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if(o1[0] == o2[0]) {
//					return o1[1] - o2[1];
//				}else {
//					return o1[0] - o2[0];
//				}
//			}
//			
//		});

		for(int i = 0; i < tc; i++) {
			sb.append(ary[i][0] + " " + ary[i][1] + "\n");
		}

		System.out.println(sb);
		
	}
}