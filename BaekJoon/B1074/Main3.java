package B1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 09:04
public class Main3 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;
  static int r = 0;
  static int c = 0;
  public static void main(String[] args) throws Exception{
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    int length = (int) Math.pow(2, n);

    split(0, 0, length, 0);

    System.out.println(sb);
  }

  public static int split(int startX, int startY, int length, int count){
    if(length == 1){
      if(startX == c && startY == r) {
        sb.append(count);
      }
      return count + 1;
    }

    if(c < startX + length/2 && r < startY + length/2){
      split(startX, startY, length/2, count);
    }else if(c < startX + length && r < startY + length/2){
      count += length/2 * length/2;
      split(startX + length/2, startY, length/2, count);

    }else if(c < startX + length/2 && r < startY + length){
      count += length/2 * length/2 * 2;
      split(startX, startY + length/2, length/2, count);

    }else if(c < startX + length && r < startY + length){
      count += length/2 * length/2 * 3;
      split(startX + length/2, startY + length/2, length/2, count);
    }

    return count;
  }
}
