import java.io.*;
import java.util.*;

public class Ex2011sol2 {
	// 16 : 21
	
	static int[] dp;
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        dp = new int[str.length() + 1];

        if(str.charAt(0) == '0'){
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= str.length(); i++){
            int num = (str.charAt(i-2) - '0') * 10 + (str.charAt(i-1) - '0');
            
            if(num < 27 && num >= 10){
                if(num % 10 == 0){
                    // 10 20 인 경우
                    dp[i] = dp[i-2];
                }else {
                    // 11 ~ 26 인 경우
                    dp[i] = dp[i-1] + dp[i-2];
                }
                dp[i] %= 1000000;
            }else if(num % 10 == 0 && ( num > 20 || num == 0) ) {
                // 00, 30, 40, ... 90 ㅇㅖ외 잡기
                dp[str.length()] = 0;
                break;
            }else {
                // 0X 인 경우
                dp[i] = dp[i-1];
                dp[i] %= 1000000;
            }
        }

        System.out.println(dp[str.length()]);
		
	}
	
}