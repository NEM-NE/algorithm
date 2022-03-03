package B10799;

import java.io.*;
import java.util.*;

public class Ex10799sol5 {
	// 10 : 39
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String pos = br.readLine();

        int curStick = 0;
        int sum = 0;
        for(int i = 0; i < pos.length() - 1; i++) {
            char cur = pos.charAt(i);
            char next = pos.charAt(i+1);

            if(cur == '(' && next == ')'){
                if(i != 0 && pos.charAt(i-1) == ')'){
                    curStick--;
                }
                sum += curStick;
            }else if(cur == '(' && next == '(') {
                if(i != 0 && pos.charAt(i-1) == ')'){
                    curStick++;
                }
                curStick++;
            }else if(cur == ')' && next == ')') {
                sum++;
                curStick--;
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
	
}