package B1021;

import java.io.*;
import java.util.*;

// 2:15
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }

    st = new StringTokenizer(br.readLine());
    int curIdx = 0;
    int result = 0;
    for(int i = 0; i < m; i++){
      int wantNum = Integer.parseInt(st.nextToken());
      int wantIdx = list.indexOf(wantNum);

      // 2, 3번을 할 필요가 없는 경우
      if (wantIdx == curIdx){
        list.remove(curIdx);
        curIdx = curIdx >= list.size() ? 0 : curIdx;
        continue;
      }

      // 1 2 3 -> 3 1 2 - 1 2 -> 2 1 - 1 - 0
      int left = searchLeft(list, wantNum, curIdx); // 왼쪽으로 탐색할 때 비용
      int right = searchRight(list, wantNum, curIdx); // 오른쪽으로 탐색할 때 비용
//      System.out.println(left + " : " + right);
      if(left < right){
        result += left;
      }else {
        result += right;
      }

      list.remove(wantIdx);
      curIdx = wantIdx >= list.size() ? 0 : wantIdx;
    }

    sb.append(result);
    System.out.println(sb);
  }

  public static int searchRight(LinkedList<Integer> list, int num, int startIdx){
    int idx = startIdx;
    int cnt = 0;
    while(list.get(idx) != num){
      cnt++;
      idx = (idx+1)%list.size();
    }

    return cnt;
  }

  public static int searchLeft(LinkedList<Integer> list, int num, int startIdx){
    int idx = startIdx;
    int cnt = 0;
    while(list.get(idx) != num){
      cnt++;
      if(idx == 0){
        idx = list.size()-1;
      }else {
        idx--;
      }
    }

    return cnt;
  }
}
