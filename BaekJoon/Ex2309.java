import java.util.*;
import java.io.*;

public class Ex2309 {
    // 4: 49
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] tallAry = new int[9];

        for(int i = 0; i < 9; i++){
            int tc = Integer.parseInt(br.readLine());
            tallAry[i] = tc;
        }

        ArrayList<Integer> list = ps(tallAry);

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append('\n');
        }

        System.out.println(sb);

    }

    public static ArrayList<Integer> ps(int[] tallAry){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                if(j == i) continue;
                int sum = 0;
                for(int k = 0; k < 9; k++) {
                    if(i == k || j == k) continue;
                    sum += tallAry[k];
                    list.add(tallAry[k]);
                }                
                if(sum != 100){
                    list.clear();
                }else return list;
            }
        }

        return list;
    }

}
