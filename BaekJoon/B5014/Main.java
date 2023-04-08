package B5014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 12:33
public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visited;
    private static int u;
    private static int d;

    public static void main(String[] args) throws Exception {
        String[] opers = br.readLine().split(" ");
        int f = Integer.parseInt(opers[0]);
        int s = Integer.parseInt(opers[1]);
        int g = Integer.parseInt(opers[2]);
        u = Integer.parseInt(opers[3]);
        d = Integer.parseInt(opers[4]);
        visited = new boolean[f+1];
        int count = bfs(s, g);

        if (g == s){
            sb.append(0);
        }else if (count == -1){
            sb.append("use the stairs");
        }else {
            sb.append(count);
        }

        System.out.println(sb);
    }

    public static int bfs(int s, int g){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int n = queue.poll();

                if ((n + u) < visited.length && !visited[n + u]) {
                    if (n + u == g) return count;
                    visited[n + u] = true;
                    queue.add(n + u);
                }

                if ((n - d) > 0 && !visited[n - d]) {
                    if (n - d == g) return count;
                    visited[n - d] = true;
                    queue.add(n - d);
                }
            }
            count++;
        }

        return -1;
    }
}
