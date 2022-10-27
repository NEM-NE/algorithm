package MaxNonoverlappingSegments;

public class Solution {
  public int solution(int[] A, int[] B) {
    int index = 0;
    int cur = 0;
    int count = 1;

    if(A.length == 0) return 0;

    cur = B[index++];
    while(index < B.length){

      if(cur < A[index]){
        count++;
        cur = B[index];
      }

      index++;
    }

    return count;
  }
}
