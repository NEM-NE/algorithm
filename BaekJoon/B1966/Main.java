package B1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 3:43
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  /*
  test case

1
4 0
2 1 4 3
-> 3

   */
  public static void main(String[] args) throws Exception {
    int n = Integer.parseInt(br.readLine());

    for(int j = 0; j < n; j++){
      st = new StringTokenizer(br.readLine());
      int size = Integer.parseInt(st.nextToken());
      int docIndex = Integer.parseInt(st.nextToken());

      // add documentation to the docQueue
      st = new StringTokenizer(br.readLine());
      Queue<Documentation> docQueue = new LinkedList<>();
      LinkedList<Integer> priorityList = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        int val = Integer.parseInt(st.nextToken());
        docQueue.add(new Documentation(val, docQueue.size()));
        priorityList.add(val);
      }

      // sort priorityList
      priorityList.sort((a, b) -> b - a);

      int priority = priorityList.removeFirst();
      int count = 0;
      while(!docQueue.isEmpty()){
        Documentation head = docQueue.poll();

        if (head.priority == priority){
          count++;

          if (head.index == docIndex) {
            break;
          }
          priority = priorityList.removeFirst();
        }else {
          docQueue.offer(head);
        }
      }

      sb.append(count).append("\n");
    }

    System.out.println(sb);
  }

  static class Documentation {
    int priority;
    int index;

    public Documentation(int priority, int index){
      this.priority = priority;
      this.index = index;
    }
  }
}
