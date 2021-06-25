package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2331 {
	// 11 : 25	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(a);
		
		int index = 0;
		while(true) {
			int num = list.get(index);
			int sum = 0;
			while(num > 0) {
				int n = num%10;
				sum += Math.pow(n, p);
				num /= 10;
			}
			
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i) == sum) {
					sb.append(i);
					System.out.println(sb);
					return;
				}
			}
			
			list.add(sum);
			index++;
			
		}
	}
	
}