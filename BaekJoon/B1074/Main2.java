package B1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main2 {
    //5:40
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int count;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);
        count = 0;

        partition(0, 0, r, c, size);
        sb.append(result);
        System.out.println(sb);
    }

    public static void partition(int xStart, int yStart, int r, int c, int size){
        if(size == 1){
            result = count;
        }

        int newSize = size/2;

        if(xStart + newSize > c && yStart + newSize > r){
            partition(xStart, yStart, r, c, newSize);
        }else if(xStart + 2 * newSize > c && yStart + newSize > r){
            count += newSize * newSize;
            partition(xStart + newSize, yStart, r, c, newSize);
        }else if(xStart + newSize > c && yStart + 2 * newSize > r){
            count += newSize * newSize * 2;
            partition(xStart, yStart + newSize, r, c, newSize);
        }else if(xStart + 2 * newSize > c && yStart + 2 * newSize > r){
            count += newSize * newSize * 3;
            partition(xStart + newSize, yStart + newSize, r, c, newSize);
        }
    }

}
