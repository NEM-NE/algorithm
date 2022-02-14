package B1463;

import java.io.*;
import java.util.*;

public class Ex1463sol3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size + 1];

        arr[1] = 0;

        for(int i = 2; i <= size; i++) {

            arr[i] = arr[i - 1] + 1;

            if(i % 3 == 0){
                arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
            }

            if(i % 2 == 0){
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            }

        }

        sb.append(arr[size]);
        System.out.println(sb);
    }
}
