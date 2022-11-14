package B17281;

import java.io.*;
import java.util.*;

//7:28 ~ 9:08
public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;
  private static ArrayList<ArrayList<Integer>> inningResults = new ArrayList<>();
  private static boolean[] selected = new boolean[9];
  private static int answer = 0;
  public static void main(String[] args) throws  Exception{
    int inning = Integer.parseInt(br.readLine());

    for(int i = 0; i < inning; i++){
      st = new StringTokenizer(br.readLine());
      inningResults.add(new ArrayList<>());

      for(int j = 0; j < 9; j++){
        inningResults.get(i).add(Integer.parseInt(st.nextToken()));
      }

    }

    selected[0] = true;
    LinkedList<Integer> players = new LinkedList<>();
    select(players,1);

    sb.append(answer);
    System.out.println(sb);
  }

  private static void select(LinkedList<Integer> players, int depth){
    if(depth == 9){
      players.add(3, 0);
      answer = Math.max(answer, startGame(players));
      players.remove(3);
      return;
    }

    for(int i = 0; i < selected.length; i++) {
      if (selected[i])
        continue;
      selected[i] = true;
      players.add(i);
      select(players, depth + 1);
      players.pollLast();
      selected[i] = false;
    }

  }

  private static int startGame(LinkedList<Integer> players){
    int index = 0;
    int score = 0;

    for (ArrayList<Integer> inningResult : inningResults) {
      int out = 0;
      LinkedList<Integer> base = new LinkedList<>();
      while (out < 3) {
        int player = players.get(index);
        int result = inningResult.get(player);

        if (result == 0)
          out++;
        else {
          base.add(result);
        }

        index = (index + 1) % 9;
      }

      int preSum = 0;
      for(int i = base.size() - 1; i >= 0; i--){
        preSum += base.get(i);
        if(preSum >= 4){
          score += i+1;
          break;
        }
      }
    }


    return score;
  }
}
