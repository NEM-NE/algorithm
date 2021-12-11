import java.io.*;
import java.util.*;

public class Ex2156sol3 {
    // 12:27
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws NumberFormatException, IOException {

        int tc = scanner.nextInt();
        int[] dp = new int[tc + 1];
        int[] list = new int[tc + 1];

        for(int i = 1; i <= tc; i++){
            list[i] = scanner.nextInt();
        }

        dp[1] = list[1];
        if(tc > 1){
            dp[2] = list[1] + list[2];
            for(int i = 3; i <= tc; i++){
                dp[i] = Math.max(dp[i-2], dp[i-3] + list[i-1]) + list[i];
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
        }

        System.out.println(dp[tc]);

    }

}