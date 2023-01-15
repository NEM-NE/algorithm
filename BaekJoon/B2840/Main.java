package B2840;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 3:16
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  public static void main(String[] args) throws Exception{
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    char[] ary = new char[n];
    for(int i = 0; i < ary.length; i++){
      ary[i] = '?';
    }

    int idx = 0;
    HashSet<Character> set = new HashSet<>();
    for(int i = 0; i < k; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      char alphabet = st.nextToken().charAt(0);

      idx = (idx + s) % ary.length;
      if (ary[idx] != '?' && ary[idx] != alphabet){
        System.out.println("!");
        System.exit(0);
      }

      if(set.contains(alphabet) && ary[idx] != alphabet){
        System.out.println("!");
        System.exit(0);
      }

      ary[idx] = alphabet;
      set.add(alphabet);
    }


    for(int i = 0; i < ary.length; i++){
      if (idx < 0) idx = ary.length-1;

      sb.append(ary[idx]);
      idx--;
    }

    System.out.println(sb);

  }

}
