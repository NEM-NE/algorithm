package rotated_digit;

import java.util.*;

class Solution {
    public int rotatedDigits(int n) {
      HashSet<Character> set = new HashSet<Character>();
      set.add('2');
      set.add('5');
      set.add('6');
      set.add('9');
      
      int cnt = 0;
      for(int i = 1; i <= n; i++) {
        String str = i + "";
        
        boolean isVaild = true;
        boolean isPureDigit = false;
        boolean c1 = true;
        for(int j = 0; j < str.length(); j++){
          char cur = str.charAt(j);
          if(cur == '1' || cur == '0' || cur == '8'){
            c1 = false;
          }else if(!set.contains(cur)) {
            isVaild = false;
          }else {
            isPureDigit = true;
          }
        }
        
        if(isVaild) {
          if(!c1 && isPureDigit) cnt++;
          else if(c1) cnt++;
        } 
      }
      
      return cnt;
    }
}