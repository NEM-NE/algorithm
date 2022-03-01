package 위장;
import java.util.*;
public class Solution2 {
    private static Map<String, Integer> map = new HashMap<String, Integer>();

    public int solution(String[][] clothesAry) {
        for(String[] clothes : clothesAry) {
            map.put(clothes[1], map.getOrDefault(clothes[1], 0) + 1);
        }

        Set set = map.entrySet();
        Iterator it = set.iterator();

        int sum = 1;
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
            sum *= entry.getValue() + 1;
        }

        sum -= 1;

        return sum;
    }
}
