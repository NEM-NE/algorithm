package B2346;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 10:04
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    int n = Integer.parseInt(br.readLine());

    LinkedList<Integer[]> list = new LinkedList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      Integer[] ary = new Integer[2];
      ary[0] = Integer.parseInt(st.nextToken());
      ary[1] = i + 1;
      list.add(ary);
    }

    int idx = 0;
    for(int i = 0; i < n; i++){
      Integer[] dir = list.remove(idx); // [3, 1]
      sb.append(dir[1]).append(" ");

      if (list.isEmpty()) break;

      if(dir[0] <= 0){
        idx = getIndexAboutSize(idx + dir[0], list.size());
      }else {
        idx = getIndexAboutSize(idx + dir[0] - 1, list.size());
      }
    }

    System.out.println(sb);
  }
  public static int getIndexAboutSize(int curIdx, int size){
    int idx = curIdx;
    if(curIdx < 0){
//      idx = idx + size;
      idx = (idx + (size * 1000)) % size;
    }else if(curIdx >= size){
      idx = idx % size;
    }

    return idx;
  }
}
