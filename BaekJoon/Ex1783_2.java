import java.util.*;
import java.io.*;


public class Main {
	
	// 11 : 45
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		if(n == 1) {
			ans = 1;
		}else if(n == 2) {
			ans = (((m-1) / 2 > 3) ? 3 : (m-1) / 2) + 1;
		}else if(m < 7) {
			ans = (m > 4) ? 4 : m;
		}else {
			ans = m - 7 + 4 + 1;
		}
		
		sb.append(ans);
		
		System.out.println(sb);
	}

}
