package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10825sol2 {
	// 12 : 54
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		String[][] ary = new String[tc][4];
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			ary[i][0] = st.nextToken();	//name
			ary[i][1] = st.nextToken();	//korea
			ary[i][2] = st.nextToken();	//eng
			ary[i][3] = st.nextToken();	//math
		}
		
		Arrays.sort(ary, new Comparator<String[]>() {
			
			public int compare(String[] o1, String[] o2) {
				if(o1[1].equals(o2[1]) && o1[2].equals(o2[2]) && o1[3].equals(o2[3])) {
					return o1[0].compareTo(o2[0]);
				}else if(o1[1].equals(o2[1]) && o1[2].equals(o2[2])) {
					return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
				}else if(o1[1].equals(o2[1])) {
					return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
				}else {
					return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
				}
			}
		});
		
		for(int i = 0; i < tc; i++) {
			sb.append(ary[i][0]).append('\n');
		}
		
		System.out.println(sb);
	}
}