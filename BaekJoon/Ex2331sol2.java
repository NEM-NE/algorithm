package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2331sol2 {
	// 5 : 02
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(a);
		
		int num = a;
		int sum = 0;
		while(true) {

			sum = 0;
			while(num > 0) {
				int n = num % 10;
				sum += Math.pow(n, b);
				num /= 10;
			}
			
			if(list.contains(sum)) {
				break;
			}
			list.add(sum);
			num = sum;
			
			
		}
		
		int ans = list.indexOf((Integer) sum);
		
		sb.append(ans);
		System.out.println(sb);
	}
	
}