package MinPerimeterRectangle;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int solution(int N) {
    int result = 2 * (N + 1);

    int i = 2;
    int limit = N/i;
    while(i <= limit){
      if(N%i == 0){
        result = Math.min(result, getPerimeter(N/i, i));
      }

      i++;
      limit = N/i;
    }

    return result;
  }

  public int getPerimeter(int a, int b){
    return (a + b) * 2;
  }
}
