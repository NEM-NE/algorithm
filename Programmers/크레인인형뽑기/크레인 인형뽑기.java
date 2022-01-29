package 크레인인형뽑기;

import java.util.*;

class Solution {
    // 10 : 10 52분
    public int solution(int[][] board, int[] moves) {
        ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
        Stack<Integer> bucket = new Stack<Integer>();
        int cnt = 0;
        
        // 스택에 데이터 삽입
        for(int i = 0; i < board.length; i++){
            stacks.add(new Stack<Integer>());
        }

        for(int i = board.length - 1; i >= 0; i--){
            for(int j = 0; j < board[i].length; j++){
                int num = board[i][j];
                if(num != 0) stacks.get(j).push(num);
            }
        }
        
        for(int i = 0; i < moves.length; i++){
            int index = moves[i] - 1;
            int num = 0;
            
            if(!stacks.get(index).isEmpty()) num = stacks.get(index).pop();
            if(num == 0) continue;  // 0일 경우 빈칸이기 때문에 바구니에 담을 필요 X
            
            if(!bucket.isEmpty()){
                int pre = bucket.peek();
                
                if(pre == num){ // 만약 이전 요소와 같을 경우 삭제
                    
                    bucket.pop();   //이미 담긴 하나를 빼준다.
                    cnt += 2;   //2개 카운트
                    continue;   //처음부터 다시
                }
            }
            
            bucket.push(num);   // 같지 않을 경우 바구니에 넣어준다.
        }
        
        return cnt;
    }
}
