package B2841;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

// 2:20
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;
  private static int count = 0;


  /*
5 15
2 8
2 10
2 12
2 10
2 5
-> 7

5 15
2 8
2 8
2 8
2 8
2 8
-> 1

1 2
6 1

5 15
2 5
3 1
4 1
5 1
6 1
-> 5

7 15
1 5
2 3
2 5
2 7
2 4
1 5
1 3
-> 9

   */

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    //create stack list
    LinkedList<Stack> stackLinkedList = new LinkedList<Stack>();
    for (int i = 0; i < 6; i++) {
      stackLinkedList.add(new Stack<Integer>());
    }

    // stack
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      int lineNum = Integer.parseInt(st.nextToken());
      int fretNum = Integer.parseInt(st.nextToken());

      Stack<Integer> stack = stackLinkedList.get(lineNum - 1);
      if(stack.isEmpty()){
        increase(stack, fretNum);
        continue;
      }

      int prevFretNum = stack.peek();

      if(prevFretNum < fretNum){
        increase(stack, fretNum);
      }else if(prevFretNum > fretNum){
        while(prevFretNum > fretNum){
          decrease(stack);

          if(stack.isEmpty()) break;
          prevFretNum = stack.peek();
        }

        if (stack.isEmpty() || prevFretNum != fretNum){
          increase(stack, fretNum);
        }
      }
    }

    sb.append(count);
    System.out.println(sb);
  }

  public static void increase(Stack<Integer> stack, int fretNum){
    stack.add(fretNum);
    count++;
  }

  public static void decrease(Stack<Integer> stack){
    stack.pop();
    count++;
  }
}
