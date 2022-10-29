package PermCheck;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int solution(int[] A) {
    Arrays.sort(A);
    return checkPermutation(A) ? 1 : 0;
  }

  public boolean checkPermutation(int[] A){
    int startNumber = 1;

    for(int num : A){
      if(num != startNumber++) return false;
    }

    return true;
  }
}