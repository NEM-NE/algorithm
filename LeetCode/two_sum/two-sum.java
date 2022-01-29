package two_sum;

import java.util.*;

class Solution {
    // 8:59
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      
      for(int i = 0; i < nums.length; i++){ 
        map.put(nums[i], i);  
      }
      
      int[] result = new int[2];
      for(int i = 0; i < nums.length; i++){
        int val = target - nums[i];
        int isVaild = map.getOrDefault(val, -1);
  
        if(isVaild != -1 && i != isVaild) {
          result[0] = i;
          result[1] = isVaild;
          break;
        }
      }
      
      Arrays.sort(result);
      
      return result;
    }
}