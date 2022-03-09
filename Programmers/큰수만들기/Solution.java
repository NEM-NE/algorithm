package 큰수만들기;

public class Solution {
    public String solution(String number, int k) {

        int kSize = k;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length(); i++){
            if(sb.length() == number.length() - k) break;
            int idx = i;
            int val = number.charAt(i) - '0';

            int length = Math.min(i + kSize, number.length() - 1);
            for(int j = i + 1; j <= length; j++){
                int num = number.charAt(j) - '0';
                if(val < num){
                    val = num;
                    idx = j;
                }
            }

            kSize -= idx - i;
            i = idx;
            sb.append(val);
        }

        return sb.toString();
    }
}
