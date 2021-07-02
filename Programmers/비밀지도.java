class Solution {
    // 6 : 43 15min
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map = new int[n][n];
        
        for(int i = 0; i < arr1.length; i++){
            int num = arr1[i];
            String str = "";
            
            while(num > 0){
                str = (num % 2) + str;
                num /= 2;
            }
            
            while(str.length() != n){
                str = 0 + str;
            }
            
            for(int j = 0; j < str.length(); j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        for(int i = 0; i < arr2.length; i++){
            int num = arr2[i];
            String str = "";
            
            while(num > 0){
                str = (num % 2) + str;
                num /= 2;
            }
            
            while(str.length() != n){
                str = 0 + str;
            }
            
            for(int j = 0; j < str.length(); j++){
                if(map[i][j] == 0) map[i][j] = str.charAt(j) - '0';
            }
        }
        
        String[] ans = new String[n];
        for(int i = 0; i < map.length; i++){
            String str = "";
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == 1){
                    str += "#";
                }else str += " ";
            }
            ans[i] = str;
        }
        
        return ans;
    }
}
