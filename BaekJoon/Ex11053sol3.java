import java.io.*;
import java.util.*;

public class Ex11053sol3 {
	// 11 : 35
	
	static int[] dp;
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

        int tc = scanner.nextInt();
        int[] map = new int[tc + 1];
        dp = new int[tc + 1];

        for(int i = 1; i <= tc; i++){
            map[i] = scanner.nextInt();
        }


        dp[1] = 1;
        for(int i = 2; i <= tc; i++){
            for(int j = 1; j < i; j++){
                if(map[j] < map[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }else {
                    dp[i] = Math.max(dp[i], 1); // 이 부분은 비효율적이니 상단 부분에서 dp[i] = 1로 선언하는게 좋을 듯
                }
            }
        }

        int maxLen = 0;
        for(int i = 1; i <= tc; i++){
            maxLen = Math.max(dp[i], maxLen);
        }

        System.out.println(maxLen);
		
	}
	
}