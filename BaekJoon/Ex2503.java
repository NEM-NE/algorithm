import java.util.*;
import java.io.*;

public class Ex2503 {
    // 2: 51
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] resultAry = new int[1000];
    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            String[] inputAry = br.readLine().split(" ");
            String input = inputAry[0];
            int strikeCnt = Integer.parseInt(inputAry[1]);
            int ballCnt = Integer.parseInt(inputAry[2]);

            for(int j = 111; j < 1000; j++){
                boolean isVaild = isCurrent(strikeCnt, ballCnt, input, j + "");
                if(isVaild) resultAry[j]++;
            }
            
        }

        int cnt = 0;
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                if(i == j) continue;
                for(int k = 1; k < 10; k++) {
                    if(i == k || j == k) continue;
                    int index = i * 100 + j * 10 + k;
                    if(resultAry[index] == tc) cnt++;
                }
            }
        }

        sb.append(cnt);
        System.out.println(sb);
    }

    public static boolean isCurrent(int strikeCnt, int ballCnt, String input, String cur) {
        char[] inputCharAry = input.toCharArray();
        char[] curCharAry = cur.toCharArray();

        int sc = 0;
        int bc = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(inputCharAry[i] == curCharAry[j]) {
                    if(i == j) sc++;
                    else bc++;
                }
            }
        }

        if(sc == strikeCnt && bc == ballCnt) return true;
        
        return false;
    }

}
