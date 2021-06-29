import java.util.*;

class Solution {
    // 12 : 02 4분
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int num = commands[i][2];
            
            int[] ary = new int[end - start + 1];
            
            //자르기
            int index = 0;
            for(int j = start; j <= end; j++){
                ary[index] = array[j-1];
                index++;
            }
            
            //정렬하기
            Arrays.sort(ary);
            
            // n번째 구하기
            answer[i] = ary[num-1];
        }
        
        return answer;
    }
}
