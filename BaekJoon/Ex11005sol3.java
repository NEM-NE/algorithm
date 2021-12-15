import java.io.*;
import java.util.*;

public class Ex11005sol3 {	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String result = "" + convertChar(n % b);

        while(n >= b){
            n /= b;
            result += convertChar(n % b);
        }

        sb.append(result);
        System.out.println(sb.reverse());
    }

    public static String convertChar(int val){
        if(val >= 10){
            return (char) ('A' + (val - 10)) + "";
        }

        return val + "";
    }
}