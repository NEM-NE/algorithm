import java.util.*;
import java.io.*;


public class Main {
	
	// 10 : 37
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		
		if(!str.contains("0")) {
			System.out.println(-1);
			return;
		}
		
		char[] ary = str.toCharArray();
		Arrays.sort(ary);
		
		long sum = 0;
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] != '0') {
				sum += ary[i] - '0';
			}
		}
		
		if(sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		
		for(int i = 0; i < ary.length; i++) {
			sb.append(ary[i]);
		}
		
		System.out.println(sb.reverse());
	}

}
