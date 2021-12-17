import java.io.*;
import java.util.*;

public class Ex1978sol2 {	
    // 09:50

    static boolean[] isNotPrimeNum = new boolean[1001];
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        checkPrimeNum();

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < tc; i++){
            int index = Integer.parseInt(st.nextToken());

            if(!isNotPrimeNum[index]) cnt++;
        }

        sb.append(cnt);
        System.out.println(sb);
    }

    public static void checkPrimeNum(){
        isNotPrimeNum[1] = true; 
        for(int i = 2; i < isNotPrimeNum.length; i++){
            for(int j = i + i; j < isNotPrimeNum.length; j += i){
                isNotPrimeNum[j] = true;
            }
        }
    }

}