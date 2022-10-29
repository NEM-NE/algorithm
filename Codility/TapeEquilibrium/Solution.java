package TapeEquilibrium;

public class Solution {
  public int solution(int[] A) {
    int rightSum = getSum(A);
    int leftSum = 0;

    int min = Integer.MAX_VALUE;
    int index = 0;
    while(index < A.length - 1){
      leftSum += A[index];
      rightSum -= A[index++];

      min = Math.min(min, Math.abs(leftSum-rightSum));
    }

    return min;
  }

  public int getSum(int[] A){
    int sum = 0;
    for(int num : A){
      sum += num;
    }

    return sum;
  }
}
