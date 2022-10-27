package OddOccurrencesInArray;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

  private Map<Integer, Integer> map = new HashMap<>();

  public int solution(int[] A) {
    for(int number : A){
      map.put(number, map.getOrDefault(number, 0) + 1);
    }

    return map.keySet().stream().filter((key) -> map.get(key) % 2 != 0).mapToInt(i -> i).toArray()[0];

  }
}
