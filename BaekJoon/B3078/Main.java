package B3078;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  /*
testcase

3 1
IVA
IVOA
ANAAA
-> 0

3 1
IVAAA
IVOA
ANAAA
-> 0

3 1
IVAAA
IVOAA
ANAAA
-> 2

3 1
IVAAA
IVOAA
ANAAA
-> 2

3 3
IVAAA
IVOAA
ANAAA

3 3
ABCDEFGHIJKLMNOPQRST
ABCDEFGHIJKLMNOPQRST
ABCDEFGHIJKLMNOPQRST
-> 3

3 3
AB
AB
AB
-> 3

4 2
IVA
IVOAA
ANAA
TOM
-> 0
   */

  public static void main(String[] args) throws Exception{
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] nameLength = new int[21];
    Queue<Integer> queue = new LinkedList<>();
    long count = 0;
    for(int i = 0; i < n; i++){
      int strIength = br.readLine().length();

      count += nameLength[strIength];
      if (queue.size() == k){
        int num = queue.poll();
        nameLength[num]--;
      }
      nameLength[strIength]++;
      queue.offer(strIength);
    }

    sb.append(count);
    System.out.println(sb);
  }

}
