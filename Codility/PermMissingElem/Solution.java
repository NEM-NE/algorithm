package PermMissingElem;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
  public int solution(int[] A) {
    Arrays.sort(A);

    int index = 1;
    for(int number : A){
      if(index != number){
        return index;
      }
      index++;
    }

    return index;
  }
}
