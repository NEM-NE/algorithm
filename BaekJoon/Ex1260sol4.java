import java.io.*;
import java.util.*;

public class Ex1260sol4 {	
    // 09:50
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] isVisited;
	public static void main(String[] args) throws IOException {		
        st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        isVisited = new boolean[v+1];
        
        for(int i = 0; i < v+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= v; i++) {
			Collections.sort(graph.get(i));
		}

        dfs(tc);
        sb.append("\n");
        isVisited = new boolean[v+1];
        bfs(tc);

        System.out.println(sb);
    }

    public static void dfs(int tc){
        sb.append(tc).append(" ");
        isVisited[tc] = true;
        for(int i = 0; i < graph.get(tc).size(); i++){
            if(!isVisited[graph.get(tc).get(i)]) {
                dfs(graph.get(tc).get(i));
            }
        }
    }

    public static void bfs(int tc){
        Queue<Integer> queue = new LinkedList<Integer>();

        isVisited[tc] = true;
        sb.append(tc).append(" ");
        queue.offer(tc);

        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int i = 0; i < graph.get(num).size(); i++) {
                if(!isVisited[graph.get(num).get(i)]){
                    isVisited[graph.get(num).get(i)] = true;
                    queue.offer(graph.get(num).get(i));
                    sb.append(graph.get(num).get(i)).append(" ");
                }
            }
        }
        
    }
}