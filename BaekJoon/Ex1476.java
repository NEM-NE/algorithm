import java.io.*;
import java.util.*;


public class Main {
	
	// 6 : 35 35분
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int year = 1;
		
		e = (e % 15 == 0) ? 0 : e % 15;
		s = (s % 28 == 0) ? 0 : s % 28;
		m = (m % 19 == 0) ? 0 : m % 19;
		
		while(true) {
			boolean isE = false;
			boolean isS = false;
			boolean isM = false;
			
			if(year % 15 == e) isE = true;
			if(year % 28 == s) isS = true;
			if(year % 19 == m) isM = true;
			
			if(isE && isS && isM) break;
			
			year++;
		}
		
		sb.append(year);
		System.out.println(sb);
		
	}

}
