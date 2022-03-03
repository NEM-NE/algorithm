package 카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 3; i < 2500; i++){
            for(int j = 3; j < 2500; j++){
                if(checkYellow(j, i, yellow) && checkBrown(j, i, brown/2)){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }

    private boolean checkYellow(int x, int y, int yellow){
        return (x-2) * (y-2) == yellow;
    }

    private boolean checkBrown(int x, int y, int halfBrown){
        return (y+x-2) == halfBrown;
    }
}
