import java.util.*;
import java.io.*;

public class Ex1654sol4 {
    // 5: 25
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[] lanAry;
    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        lanAry = new long[k];
        int max = 0;
        for(int i = 0; i < k; i++){
            int length = Integer.parseInt(br.readLine());
            max = Math.max(max, length);
            lanAry[i] = length;
        }

        long result = binarySearch(max, n);

        sb.append(result);
        System.out.println(sb);
    }

    public static long binarySearch(long max, int ans){
        long min = 1;
        long result = 0;
    
        max++;
        while(min < max) {
            long mid = (max + min) / 2;

            int cnt = 0;
            for(int i = 0; i < lanAry.length; i++){
                cnt += lanAry[i]/mid;
            }

            if(cnt < ans){
                max = mid;
            }else {
                result = Math.max(result, mid);
                min = mid + 1;
            }
        }

        return result;
    }

}
