import java.util.*;
import java.io.*;

public class Ex1182 {
    // 6: 50
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] ary;
    static ArrayList<ArrayList<Integer>> history;
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] condition = br.readLine().split(" ");
        int n = Integer.parseInt(condition[0]);
        int s = Integer.parseInt(condition[1]);
        ary = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            ary[i] = Integer.parseInt(input[i]);
        }

        history = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            history.add(new ArrayList<Integer>());
        }


        int count = 0;
        for(int i = 1; i <= n; i++){    // 뽑을 갯수 설정
            count += ps(i, 0, 0, s);
        }

        sb.append(count);
        System.out.println(sb);
        
    }

    public static int ps(int i, int sum, int index, int s){
        if(i == 0) return (sum == s) ? 1 : 0;
        if(index >= ary.length) return 0;

        int result = 0;
        for(int j = index; j < ary.length; j++){
            result += ps(i-1, sum + ary[j], j+1, s);
        }

        return result;
    }

}
