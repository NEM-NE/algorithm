package B2644;

import java.util.*;
import java.io.*;

public class Main {
    // 12:16
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++){
            map.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            map.get(k).add(p);
            map.get(p).add(k);
        }

        visited = new boolean[n+1];
        int result = bfs(a, b);
        sb.append(result);
        System.out.println(sb);

    }

    static int bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[x] = true;
        queue.add(x);

        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;

            for(int j = 0; j < size; j++){
                int num = queue.poll();

                for(int i = 0; i < map.get(num).size(); i++){
                    if(!visited[map.get(num).get(i)]){
                        if(map.get(num).get(i) == y) return depth;
                        queue.add(map.get(num).get(i));
                        visited[map.get(num).get(i)] = true;
                    }
                }
            }
        }

        return -1;

    }

}
