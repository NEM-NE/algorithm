package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11728 {
	// 2 : 10
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] ary = new int[a];
		int[] ary2 = new int[b];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < b; i++) {
			ary2[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0, index2 = 0;
		
		while(index < a && index2 < b) {
			
			if(ary[index] > ary2[index2]) {
				sb.append(ary2[index2] + " ");
				index2++;
			}else {
				sb.append(ary[index] + " ");
				index++;
			}
		}
		
		while(index < a) {
			sb.append(ary[index] + " ");
			index++;
		}
		
		while(index2 < b) {
			sb.append(ary2[index2] + " ");
			index2++;
		}
		
		System.out.println(sb);
	}

}