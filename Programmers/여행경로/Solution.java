package 여행경로;
import java.util.*;

public class Solution {
    static int size;
    static ArrayList<String> result;
    static Map<String, Queue<String>> map;
    public String[] solution(String[][] tickets) {
        size = tickets.length + 1;
        result = new ArrayList<String>();
        map = new HashMap<String, Queue<String>>();

        for(String[] ticket : tickets){
            Queue<String> queue = map.getOrDefault(ticket[0], new LinkedList<String>());
            queue.offer(ticket[1]);
            map.put(ticket[0], queue);
        }

        dfs("ICN", "ICN");

        Collections.sort(result);
        String str = result.get(0);
        String[] answer = new String[size];
        for(int i = 0; i < str.length(); i+=3){
            answer[i/3] = str.substring(i, i+3);
        }

        return answer;
    }

    private static void dfs(String str, String sum){
        if(sum.length()/3 == size) result.add(sum);
        if(!map.containsKey(str)) return;

        Queue<String> queue = map.get(str);
        if(queue.isEmpty()) return;
        int idx = queue.size() - 1;
        for(int i = idx; i >= 0; i--){
            String next = queue.poll();
            dfs(next, sum + next);
            queue.offer(next);
        }
    }
}
