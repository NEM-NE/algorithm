package B2304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 12:16
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;


  /*

7
2 4
11 4
15 8
4 6
5 3
8 10
13 6

8
2 4
11 4
15 8
4 6
5 3
8 10
13 6
14 10

-> 110

1
2 10

-> 10

5
1 10
2 10
3 10
4 10
5 10

   */
  public static void main(String[] args) throws Exception{
    int n = Integer.parseInt(br.readLine());

    LinkedList<Roof> list = new LinkedList<>();
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      Roof roof = new Roof(x, y);
      list.add(roof);
    }

    list.sort((a, b) -> a.x - b.x);

    int maxY = 0;
    int index = 0;
    for (int i = 0; i < list.size(); i++) {
      Roof roof = list.get(i);
      if(roof.y > maxY){
        maxY = roof.y;
        index = i;
      }
    }

    LinkedList<Integer> sum = new LinkedList<>();

    //left
    Roof roof = list.get(0);
    for(int i = 1; i < index; i++){
      Roof newRoof = list.get(i);

      if (roof.y < newRoof.y) {
        sum.add(roof.y * (newRoof.x - roof.x));
        roof = newRoof;
      }
    }
    sum.add(roof.y * (list.get(index).x - roof.x));


    //right
    roof = list.get(list.size() - 1);
    for (int i = list.size()-1; i > index; i--) {
      Roof newRoof = list.get(i);

      if (roof.y < newRoof.y) {
        sum.add(roof.y * (roof.x - newRoof.x));
        roof = newRoof;
      }
    }
    sum.add(roof.y * (roof.x - list.get(index).x));
    sum.add(maxY);

    sb.append(sum.stream().reduce(Integer::sum).get());
    System.out.println(sb);


  }

  static class Roof {
    int x, y;

    public Roof(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}
