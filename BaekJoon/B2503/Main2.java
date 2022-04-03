package B2503;

import java.io.*;
import java.util.*;

public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] listAry = new int[1000];

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            solve(str, strike, ball);
        }

        int sum = 0;
        for(int i = 123; i < listAry.length; i++){
            if(listAry[i] == tc) sum++;
        }

        sb.append(sum);
        System.out.println(sb);
    }

    private static void solve(String str, int strike, int ball){
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                if(i == j) continue;
                for(int k = 1; k < 10; k++){
                    if(i == k || j == k) continue;
                    String caseStr = "" + i + j + k;

                    int strikeCnt = 0;
                    int ballCnt = 0;
                    for(int l = 0; l < 3; l++){
                        if(str.contains(caseStr.charAt(l) + "")){
                            if(str.charAt(l) == caseStr.charAt(l)) strikeCnt++;
                            else ballCnt++;
                        }
                    }

                    if(strike == strikeCnt && ball == ballCnt){
                        listAry[Integer.parseInt(caseStr)]++;
                    }
                }
            }
        }
    }
}
