package 네트워크;

import java.util.*;

public class Solution {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        list = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int j = 0; j < computers.length; j++){
            int[] computer = computers[j];
            for(int i = 0; i < computer.length; i++){
                if(j == i) continue;
                if(computer[i] == 1) list.get(j).add(i);
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i);
                result++;
            }
        }

        return result;
    }

    private static void dfs(int n){
        visited[n] = true;

        for(int i = 0; i < list.get(n).size(); i++){
            if(!visited[list.get(n).get(i)]){
                dfs(list.get(n).get(i));
            }
        }
    }
}
