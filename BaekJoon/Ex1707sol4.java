import java.io.*;
import java.util.*;

public class Ex1707sol4 {	
    // 12:00
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isVisited;
    static boolean isBipartite;
	public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());		
        for(int i = 0; i < tc; i++){
            boolean isBipartite = checkBipartite();
            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    public static boolean checkBipartite() throws IOException{
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        isBipartite = true;
        graph = new ArrayList<ArrayList<Integer>>();
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

        for(int i = 1; i < v+1; i++){
            if(!isVisited[i]) bfs(i);
        }

        return isBipartite;
    }

    public static void bfs(int tc){
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<HashSet<Integer>> depthList = new ArrayList<HashSet<Integer>>();
        depthList.add(new HashSet<Integer>());
        int depth = 0;
        isVisited[tc] = true;
        queue.offer(tc);

        while(!queue.isEmpty()){
            int size = queue.size();
            depthList.add(new HashSet<Integer>());
            for(int j = 0; j < size; j++){
                int num = queue.poll();
                for(int i = 0; i < graph.get(num).size(); i++){
                    if(!isVisited[graph.get(num).get(i)]){
                        isVisited[graph.get(num).get(i)] = true;
                        queue.offer(graph.get(num).get(i));
                        depthList.get(depth + 1).add(graph.get(num).get(i));
                    }else if(depthList.get(depth).contains(graph.get(num).get(i))){
                        isBipartite = false;
                    }
                }
            }
            depth++;
        }
        
    }
    
}