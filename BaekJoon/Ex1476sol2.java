import java.io.*;
import java.util.*;


public class Main {
	
	// 6 : 20 5min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int year = 1;
		while(true) {
			int E = (year % 15 == 0) ? 15 : year % 15;
			int S = (year % 28 == 0) ? 28 : year % 28;
			int M = (year % 19 == 0) ? 19 : year % 19;
			
			if(E == e && S == s && M == m) break;
			
			year++;
		}
		
		sb.append(year);
		System.out.println(sb);
	}

}
