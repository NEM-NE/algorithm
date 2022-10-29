package MaxSliceSum;

public class Solution {
  public int solution(int[] A) {
    int result = Integer.MIN_VALUE;
    int local = -1000001;
    for(int i = 0; i < A.length; i++){
      local = Math.max(local + A[i], A[i]);
      result = Math.max(result, local);
    }

    return result;
  }
}
