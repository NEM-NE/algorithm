package CyclicRotation;

public class Solution {
  public int[] solution(int[] A, int K) {
    int[] result = new int[A.length];
    if(result.length == 0) return result;

    int index = A.length - (K % A.length);
    for(int i = 0; i < result.length; i++){
      result[i] = A[index++ % A.length];

    }

    return result;
  }
}
