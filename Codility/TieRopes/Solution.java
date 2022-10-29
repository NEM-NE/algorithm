package TieRopes;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
  public int solution(int K, int[] A) {
    int count = 0;

    int sum = 0;
    for(int i = 0; i < A.length; i++){
      sum += A[i];
      if(sum >= K){
        sum = 0;
        count++;
      }
    }

    return count;
  }
}
