package 할인행사;

import java.util.*;
// 8:35 - 9:09
class Solution {
  public int solution(String[] want, int[] number, String[] discount) {
    int result = 0;
    for(int i = 0; i <= discount.length - 10; i++){
      // 1.
      HashMap<String, Integer> map = new HashMap<String, Integer>();
      for(int j = 0; j < want.length; j++){
        map.put(want[j], number[j]);
      }

      result += canIBuyMembership(map, discount, i) ? 1 : 0;
    }

    return result;
  }

  public boolean canIBuyMembership(Map<String, Integer> map, String[] discount, int i){
    for(int j = i; j < i + 10; j++){
      String saleProduct = discount[j];

      if(!map.containsKey(saleProduct) || map.get(saleProduct) == 0) return false;
      map.put(saleProduct, map.get(saleProduct) - 1);
    }

    boolean isRemain = false;
    for(String key : map.keySet()){
      if(map.get(key) != 0){
        isRemain = true;
      }
    }

    return isRemain ? false : true;
  }
}