package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10824 {
	// 10 : 22
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		long sum = 0;
		for(int i = 0; i < 4; i+=2) {
			long num = Long.parseLong(st.nextToken() + st.nextToken());
			sum += num;
		}

		sb.append(sum);
		System.out.println(sb);
	}
}