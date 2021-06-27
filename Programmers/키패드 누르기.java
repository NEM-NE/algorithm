class Solution {
    // 11 : 00 53분
        
    static int[] leftLocation;
    static int[] rightLocation;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        leftLocation = new int[2];
        rightLocation = new int[2];
        
        leftLocation[0] = 0;
        leftLocation[1] = 3;
        
        rightLocation[0] = 2;
        rightLocation[1] = 3;
        
        for(int i = 0; i < numbers.length; i++){
            int num = numbers[i];
            
            int x = 0;
            int y = 0;
            
            int temp = num;
            while(temp > 3) {
                temp -= 3;
                y++;
            }
            
            if(num == 0){
                x = 1;
                y = 3;
            }
            
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                //위치조정
                leftLocation[0] = 0;
                leftLocation[1] = y;
            }else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                //위치조정
                rightLocation[0] = 2;
                rightLocation[1] = y;
            }else{
                x = 1;
        
                boolean left = false;
                boolean right = false;
                
                for(int j = 0; j < 4; j++){
                    int xx = leftLocation[0] + dx[j];
                    int yy = leftLocation[1] + dy[j];
                    int xxx = rightLocation[0] + dx[j];
                    int yyy = rightLocation[1] + dy[j];
                    
                    
                    if(xx == x && yy == y) left = true;
                    if(xxx == x && yyy == y) right = true;
                }
                
                if(!left && !right){
                    int l = Math.abs(x - leftLocation[0]) +
                                Math.abs(y - leftLocation[1]);
                    int r = Math.abs(x - rightLocation[0]) +
                                Math.abs(y - rightLocation[1]);

                    if(l < r) left = true;
                    else if(l > r) right = true;
                    else {
                        left = true;
                        right = true;
                    }
                }
                
                if(left && !right || (left && right && hand.equals("left"))){   // left가 가까울 때
                    leftLocation[0] = x;
                    leftLocation[1] = y;
                    answer += "L";
                }else if(!left && right || (left && right && hand.equals("right"))){ //right가 가까울 때
                    rightLocation[0] = x;
                    rightLocation[1] = y;
                    answer += "R";
                }
            }
        }
        
        return answer;
    }
}
