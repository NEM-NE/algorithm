import java.io.*;
import java.util.*;

public class Ex2609sol2 {
	// 10 : 39
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcf = gcd(a, b);

        int gcm = (a/gcf) * (b/gcf) * gcf;

        sb.append(gcf).append("\n");
        sb.append(gcm);

        System.out.println(sb);
        
    }

    public static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b % a, a);
    }
	
}