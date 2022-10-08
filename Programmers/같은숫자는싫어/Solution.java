package 같은숫자는싫어;

import java.util.*;

public class Solution {
  public int[] solution(int[] arr) {
    LinkedList<Integer> result = new LinkedList<Integer>();

    Arrays.stream(arr).forEach((num) -> {
      if(result.size() == 0 || result.peekLast() != num) result.add(num);
    });


    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}