import java.io.*;
import java.util.*;

public class Ex9466sol2 {	
    // 9:18
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<ArrayList<Integer>> graph;
    static int[] isVisited;
    static HashSet<Integer> set;
	public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            int result = getAnswer();

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int getAnswer() throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<Integer>>();
        st = new StringTokenizer(br.readLine());
        set = new HashSet<Integer>();
        isVisited = new int[size + 1];
        
        for(int i = 0; i < size + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 1; i <= size; i++){
            int num = Integer.parseInt(st.nextToken());
            graph.get(i).add(num);
        }

        for(int i = 1; i <= size; i++){
            if(isVisited[i] == 0) dfs(i);
        }

        return size - set.size();
    }


    public static void dfs(int num){        
        if(isVisited[num] == 2) {
            set.add(num);
        }else if(isVisited[num] == 3) return;

        isVisited[num]++;

        if(isVisited[graph.get(num).get(0)] < 3){
            int idx = graph.get(num).get(0);
            dfs(idx);
        }
    }
    
}