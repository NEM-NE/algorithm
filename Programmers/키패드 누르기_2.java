class Solution {
    //11 : 32 25분
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int l = 10;
        int r = 12;
        
        for(int i = 0; i < numbers.length; i++){
            int num = (numbers[i] == 0) ? 11 : numbers[i];
            
            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                l = num;
            }else if(num == 3 || num == 6 || num == 9){
                sb.append("R");
                r = num;
            }else {
                int x = (num % 3 == 0) ? 3 : num % 3;
                int y = (num % 3 == 0) ? num / 3 : num / 3 + 1;
                
                int leftX = (l % 3 == 0) ? 3 : l % 3;
                int leftY = (l % 3 == 0) ? l / 3 : l / 3 + 1;
                
                int rightX = (r % 3 == 0) ? 3 : r % 3;
                int rightY = (r % 3 == 0) ? r / 3 : r / 3 + 1;
                
                int ll = Math.abs(x - leftX) + Math.abs(y - leftY);
                
                int rr = Math.abs(x - rightX) + Math.abs(y - rightY);
                
                if(ll < rr || (hand.equals("left") && ll == rr)){
                    sb.append("L");
                    l = num;
                }else if(ll > rr || (hand.equals("right") && ll == rr)){
                    sb.append("R");
                    r = num;
                }
            }
        }
        
        return sb.toString();
        
    }
}
