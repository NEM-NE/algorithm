package PassingCars;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
  public int solution(int[] A) {
    int count = 0;
    int multiple = 0;

    for(int num : A){
      if(num == 0){
        multiple++;
      }else {
        count += multiple;
      }
    }

    return count > 1000000000 || count < 0 ? -1 : count;
  }
}
