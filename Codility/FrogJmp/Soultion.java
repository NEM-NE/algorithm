package FrogJmp;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int solution(int X, int Y, int D) {
    int distance = Y - X;
    int result = (distance / D) + ((distance % D != 0) ? 1 : 0);

    return result;
  }
}
