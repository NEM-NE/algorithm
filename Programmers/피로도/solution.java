package 피로도;

class Solution {
    static int answer;
    static int[][] dungeons;
    static boolean[] visited;
    public int solution(int k, int[][] ary) {
        answer = -1;
        dungeons = ary;
        visited = new boolean[dungeons.length];
        
        dfs(k, 0);
        
        return answer;
    }
    
    public static void dfs(int k, int cnt){
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            dfs(k - dungeons[i][1], cnt + 1);
            visited[i] = false;
        }
        
        answer = Math.max(answer, cnt);
    }
}