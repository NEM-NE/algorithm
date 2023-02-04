package B3986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

// 2:36

/*
testcases

1
ABBBAB
-> 0

1
ABBBBABB
-> 1

 */

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    int n = Integer.parseInt(br.readLine());

    int cnt = 0;
    for(int i = 0; i < n; i++){
      String str = br.readLine();
      LinkedList<Character> stack = new LinkedList<>();

      for (int j = 0; j < str.length(); j++) {
        char cur = str.charAt(j);
        if(stack.isEmpty()){
          stack.add(cur);
          continue;
        }

        char prev = stack.getLast();
        if(prev == cur){
          stack.pollLast();
        }else {
          stack.add(cur);
        }

      }

      if(stack.isEmpty()) cnt++;

    }

    sb.append(cnt);
    System.out.println(sb);
  }

}
