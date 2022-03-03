package B10799;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Stack<Character> stack = new Stack<Character>();
        String str = br.readLine();

        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            if(cur == '('){
                stack.add(cur);
            }else if(cur == ')'){
                if(i == 0) continue;
                char prev = str.charAt(i-1);
                if(prev == '('){
                    stack.pop();
                    sum += stack.size();
                }else {
                    stack.pop();
                    sum++;
                }
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
}
