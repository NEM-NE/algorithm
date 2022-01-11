import java.util.*;
import java.io.*;

public class Ex2231 {
    // 5: 12
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i = 1; i < n; i++){
            result = ps(i, n);
            if(result != 0) break;
        }

        sb.append(result);
        System.out.println(sb);
    }

    public static int ps(int i, int n){
        int num = i;
        int sum = i;

        while(num > 0){
            sum += num % 10;
            num /= 10;
        }

        if(sum == n){
            return i;
        }

        return 0;
    }

}
