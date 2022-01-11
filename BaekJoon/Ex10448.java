import java.util.*;
import java.io.*;

public class Ex10448 {
    // 6: 30
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            int num = Integer.parseInt(br.readLine());
            int result = ps(num);

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    public static int ps(int num) {
        for(int i = 1; i < num-1; i++){
            for(int j = 1; j < num-i; j++){
                for(int k = 1; k <= num-i-j; k++){
                    int triSum = getTriNum(i) + getTriNum(j) + getTriNum(k);
                    if(triSum == num) return 1;
                }
            }
        }

        return 0;
    }

    public static int getTriNum(int num){
        return ((num+1)*num)/2;
    }
}
