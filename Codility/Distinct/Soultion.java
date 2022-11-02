package Distinct;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int solution(int[] A) {
    Set<Integer> set = new HashSet<>();
    for(int num : A){
      set.add(num);
    }

    return set.size();
  }
}