package 캐시;
import java.util.*;

// 9:23 -> 41
public class Solution2 {
  public int solution(int cacheSize, String[] cities) {
    LinkedList<String> cache = new LinkedList<String>();

    int answer = 0;
    for(String temp : cities) {
      String str = temp.toLowerCase();
      //check cache
      if(cache.contains(str)){
        answer++; // hit
        cache.remove(str);
      }else {
        answer += 5; // miss
        if(cache.size() == cacheSize) cache.poll();
      }

      if(cache.size() < cacheSize) cache.add(str);
    }

    return answer;
  }
}
