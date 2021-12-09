import java.io.*;
import java.util.*;

public class Ex9465sol4 {
    // 10:50
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws NumberFormatException, IOException {

        int tc = scanner.nextInt();

        for(int i = 0; i < tc; i++){
            int size = scanner.nextInt();
            int result = startPS(size);
            System.out.println(result);
        }
    }

    public static int startPS(int size){
        int[][] map = new int[2][size + 1];
        int[][] dp = new int[2][size + 1];

        for(int i = 0; i < 2; i++){
            for(int j = 1; j <= size; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        dp[0][1] = map[0][1];
        dp[1][1] = map[1][1];

        if(size < 2){
            return Math.max(dp[0][size], dp[1][size]);
        }

        dp[0][2] = map[0][2] + map[1][1];
        dp[1][2] = map[1][2] + map[0][1];

        for(int i = 3; i <= size; i++){
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i]; 

            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i]; 
        }

        return Math.max(dp[0][size], dp[1][size]);
    }

}
