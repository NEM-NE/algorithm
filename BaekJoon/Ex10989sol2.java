import java.io.*;
import java.util.*;

public class Ex10989sol2 {
	// 5 : 26
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        int tc = Integer.parseInt(br.readLine());
        int[] sortAry = new int[10001];

        for(int i = 0; i < tc; i++){
            int num = Integer.parseInt(br.readLine());

            sortAry[num]++;
        }

        for(int i = 0; i < sortAry.length; i++){
            for(int j = 0; j < sortAry[i]; j++){
                sb.append(i).append("\n");
            }
        }
        System.out.println("====");
        System.out.println(sb);
    }
	
}