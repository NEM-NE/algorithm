package B1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //3:05
    static int result;
    static int cnt;
    static int r;
    static int c;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        result = 0;
        cnt = 0;

        partition(0, 0, size);

        sb.append(result);
        System.out.println(sb);
    }

    public static void partition(int xStart, int yStart, int size){
        if(size == 1){
            result = cnt;
        }else {
            int newSize = size/2;

            if((yStart + newSize) > r && (xStart + newSize) > c) {
                partition(xStart, yStart, newSize);
            }else if((yStart + newSize) > r && (xStart + 2 * newSize) > c) {
                cnt += newSize * newSize;
                partition(xStart + newSize, yStart, newSize);
            }else if((yStart + 2 * newSize) > r && (xStart + newSize) > c) {
                cnt += (newSize * newSize) * 2;
                partition(xStart, yStart + newSize, newSize);
            }else if((yStart + 2 * newSize) > r && (xStart + 2 * newSize) > c) {
                cnt += (newSize * newSize) * 3;
                partition(xStart + newSize, yStart + newSize, newSize);
            }
        }
    }
}

