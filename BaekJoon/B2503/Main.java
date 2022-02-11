package B2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //1:24
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] availableCase;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        availableCase = new boolean[1000];

        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());

            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            enrollCase(num, strike, ball, i);
        }

        int cnt = 0;
        for(int i = 100; i < availableCase.length; i++){
            if(availableCase[i]) {
                cnt++;
            }
        }

        sb.append(cnt);
        System.out.println(sb);
    }

    public static void enrollCase(String num, int strike, int ball, int depth){
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                if(j == i) continue;
                for(int k = 1; k < 10; k++){
                    if(j == k || i == k) continue;
                    boolean[] strikeInspectAry = new boolean[3];
                    int strikeCnt = 0;
                    int ballCnt = 0;
                    int first = (num.charAt(0) - '0');
                    int second = (num.charAt(1) - '0');
                    int third = (num.charAt(2) - '0');

                    if(third == k) {
                        strikeCnt++;
                        strikeInspectAry[2] = true;
                    }
                    if(second == j) {
                        strikeCnt++;
                        strikeInspectAry[1] = true;
                    }
                    if(first == i) {
                        strikeCnt++;
                        strikeInspectAry[0] = true;
                    }

                    for(int p = 0; p < strikeInspectAry.length; p++){
                        if(strikeInspectAry[p]) continue;
                        String str = (i * 100 + j * 10 + k) + "";
                        int index = str.indexOf(num.charAt(p));
                        if(index != p && index != -1) ballCnt++;
                    }

                    if(strike == strikeCnt && ball == ballCnt && depth == 0) availableCase[i * 100 + j * 10 + k] = true;
                    else if(strike != strikeCnt || ball != ballCnt) availableCase[i * 100 + j * 10 + k] = false;

                }
            }
        }
    }

}
