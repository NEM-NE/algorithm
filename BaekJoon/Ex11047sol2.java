import java.util.*;
import java.io.*;

public class Ex11047sol2 {
    // 10:19
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coinAry = new int[n];
        for(int i = 0; i < n; i++){
            coinAry[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        while(k != 0){
            for(int i = n-1; i >= 0; i--){
                if(k >= coinAry[i]) {
                    k -= coinAry[i];
                    cnt++;
                    break;
                }
            }
        }

        sb.append(cnt);
        System.out.println(sb);
    }

}
