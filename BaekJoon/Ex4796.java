import java.util.*;
import java.io.*;

public class Ex4796 {
    // 5: 16
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {

        int count = 1;
        while(true){
            st = new StringTokenizer(br.readLine()); 
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int rest = p - l;
            if(l == 0 && p == 0 && v == 0) break;

            int maxDay = 0;
            while(v >= l) {
                v -= l;
                v -= rest;
                maxDay += l;
            }

            maxDay += (v > 0 ) ? v : 0;

            sb.append("Case ").append(count).append(": ").append(maxDay).append('\n');
            count++;
        }

        System.out.println(sb);
        
    }

}
