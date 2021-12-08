import java.io.*;

public class Ex11057sol3 {
    // 10:22
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int[][] dp = new int[tc + 1][10];
        
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= tc; i++){
            for(int j = 0; j < 10; j++){
                if(j == 0){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    dp[i][j] %= 10007;
                }
            }
        }
        

        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += dp[tc][i];
            sum %= 10007;
        }
        sb.append(sum);
        System.out.println(sb);
    }
}
