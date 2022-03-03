package HIndex;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        for(int i = 1; i <= citations.length; i++){
            if(findOver(citations, i) && findUnder(citations, i)) answer = i;
        }

        return answer;
    }

    private static boolean findOver(int[] citations, int standard){
        int cnt = 0;
        for(int num : citations){
            if(num >= standard) cnt++;
        }
        return standard <= cnt;
    }

    private static boolean findUnder(int[] citations, int standard){
        int cnt = 0;
        for(int num : citations){
            if(num <= standard) cnt++;
        }
        return standard >= cnt;
    }
}