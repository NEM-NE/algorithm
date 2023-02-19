package B5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

// 3:07
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  /*
  testcase
1
R
1
[1]
-> [1]

1
R
2
[2,1]
-> [1,2]

   */

  public static void main(String[] args) throws Exception {
    int n = Integer.parseInt(br.readLine());

    for(int j = 0; j < n; j++){
      // initialize
      String oper = br.readLine();
      int len = Integer.parseInt(br.readLine());
      String numList = br.readLine();
      LinkedList<Integer> list = len == 0 ? new LinkedList<>() : getList(numList);

      // calculate
      boolean isReverse = false;
      boolean isError = false;
      for (int i = 0; i < oper.length(); i++) {
        char cur = oper.charAt(i);

        if (cur == 'R') {
          isReverse = !isReverse;
        }else if (cur == 'D') {
          if (list.isEmpty()) {
            isError = true;
            break;
          }

          if (isReverse) {
            list.pollLast();
          }else {
            list.pollFirst();
          }
        }

      }

      // print result
      if (isError) {
        sb.append("error");
      }else {
        if (isReverse){
          Collections.reverse(list);
        }

        sb.append(list.toString().replaceAll(" ", ""));
      }

      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static LinkedList<Integer> getList(String numList){
    numList = numList.replace("[", "").replace("]", "");
    String[] num = numList.split(",");

    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < num.length; i++) {
      list.add(Integer.parseInt(num[i]));
    }

    return list;
  }

}
