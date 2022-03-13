package 단어변환;

import java.util.*;

public class Solution {
    static String TARGET;
    static String[] WORDS;
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<String, Integer>();
    static int result;
    public int solution(String begin, String target, String[] words) {
        TARGET = target;
        WORDS = words;
        result = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }

        visited = new boolean[words.length+1];
        map.put(begin, words.length);
        dfs(0, begin);

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private static void dfs(int depth, String begin){
        if(TARGET.equals(begin)){
            result = Math.min(result, depth);
        }

        for(int i = 0; i < WORDS.length; i++){
            int canChange = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) != WORDS[i].charAt(j)){
                    canChange++;
                }
            }

            if(canChange == 1 && !visited[map.get(WORDS[i])]){
                visited[map.get(WORDS[i])] = true;
                dfs(depth + 1, WORDS[i]);
                visited[map.get(WORDS[i])] = false;
            }
        }

    }
}
