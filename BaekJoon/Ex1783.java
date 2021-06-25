import java.util.*;
import java.io.*;


public class Main {
	
	// 10 : 25
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		if(n == 1) {
			cnt = 1;
		}else if(n == 2) {
			int num = (m-1) / 2 + 1;
			cnt = (num > 4) ? 4 : num;
		}else if(m < 7) {
			cnt = (m > 4) ? 4 : m;
		}else {
			cnt = 4 + m - 7 + 1;
		}
		
		sb.append(cnt);
		
		System.out.println(sb);
	}

}
