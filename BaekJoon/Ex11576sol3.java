package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11576sol3 {
	// 11 : 41	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int tc = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for(int i = 0; i < tc; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num * Math.pow(a, tc-1-i);
		}
		ArrayList<Integer> list = new ArrayList<>();
		
		while(sum > 0) {
			int num = sum%b;
			list.add(num);
			sum /= b;
		}
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(list.size()-1-i)).append(" ");
			
		}
		
		System.out.println(sb);
		
		
	}
	
}