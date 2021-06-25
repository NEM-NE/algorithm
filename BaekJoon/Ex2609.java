package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2609 {
	// 8 : 11
	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcf = getGCF(a, b);
		int lcm =(a*b) / gcf;
		
		
		sb.append(gcf).append('\n');
		sb.append(lcm).append('\n');
		
		System.out.println(sb);
	}

	private static int getGCF(int a, int b) {
		if(b == 0) return a;
		return getGCF(b, a%b);
	}

}