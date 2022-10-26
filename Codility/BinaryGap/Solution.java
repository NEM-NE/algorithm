package BinaryGap;

import java.util.*;

class Solution {
  private int max = 0;
  private boolean isStart = false;

  public int solution(int N) {
    String binary = Integer.toBinaryString(N);

    int cnt = 0;
    for(int i = 0; i < binary.length(); i++){
      char cur = binary.charAt(i);


      if(cur == '1'){
        if(isStart){ // finish counting
          max = Math.max(max, cnt);
          cnt = 0;
        }else { // start counting!
          isStart = true;
        }
      }else if(isStart){
        cnt++;
      }
    }

    return max;
  }
}
