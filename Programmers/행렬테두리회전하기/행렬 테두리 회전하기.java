package 행렬테두리회전하기;

//11:02
class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows + 1][columns + 1];
        
        for(int i = 1; i < map.length; i++){
            for(int j = 1; j < map[0].length; j++){
                map[i][j] = ((i-1) * columns + j);
            }
        }
        
        for(int i = 0; i < queries.length; i++){
            int y1 = queries[i][0];
            int x1 = queries[i][1];
            int y2 = queries[i][2];
            int x2 = queries[i][3];
            
            answer[i] = getMinimum(x1, y1, x2, y2);
        }
        return answer;
    }
    
    public static int getMinimum(int x1, int y1, int x2, int y2){
        int x = x1;
        int y = y1;
        int temp = map[y1][x1];
        int min = Integer.MAX_VALUE;
        //가로 1층
        for(int i = x1; i < x2; i++){
            int temp2 = map[y1][i + 1];
            map[y1][i + 1] = temp;
            temp = temp2;
            min = Math.min(min, map[y1][i + 1]);
        }
        
        //우측 세로
        for(int i = y1; i < y2; i++){
            int temp2 = map[i + 1][x2];
            map[i + 1][x2] = temp;
            temp = temp2;
            min = Math.min(min, map[i + 1][x2]);
        }

        
        //아래 가로
        for(int i = x2; i > x1; i--){
            int temp2 = map[y2][i - 1];
            map[y2][i - 1] = temp;
            temp = temp2;
            min = Math.min(min, map[y2][i - 1]);
        }
        
        //좌측 세로
        for(int i = y2; i > y1; i--){
            int temp2 = map[i - 1][x1];
            map[i - 1][x1] = temp;
            temp = temp2;
            min = Math.min(min, map[i - 1][x1]);
        }
        
        return min;
    }
}