package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11576 {
	// 10 : 23
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int tc = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for(int i = tc-1; i >= 0; i--) {
			int numA = Integer.parseInt(st.nextToken());
			sum += numA * Math.pow(a, i);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		while(sum > 0) {
			int num = sum%b;
			list.add(num);
			sum /= b;
		}

		for(int i = list.size()-1; i >= 0; i--) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}
	

}