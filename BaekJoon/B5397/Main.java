package B5397;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  // 4:10
  public static void main(String[] args) throws Exception{
    int tc = Integer.parseInt(br.readLine());

    for(int i = 0; i < tc; i++){
      String input = br.readLine();
      LinkedList<Character> prev = new LinkedList<>();
      LinkedList<Character> next = new LinkedList<>();
      for(int j = 0; j < input.length(); j++){
        char cur = input.charAt(j);

        if(cur == '<' && !prev.isEmpty()){ // prev에서 빼서 next에 넣기
          next.addFirst(prev.pop());
        }else if(cur == '>' && !next.isEmpty()){ // next에서 빼서 prev에 넣기
          prev.addFirst(next.pop());
        }else if(cur == '-' && !prev.isEmpty()){ // cur 삭제
          prev.pop();
        }else if (cur != '>' && cur != '<' && cur != '-'){ // prev 최전방에 넣기
          prev.addFirst(cur);
        }
      }

      while(!prev.isEmpty()){
        sb.append(prev.pollLast());
      }

      while(!next.isEmpty()){
        sb.append(next.pollFirst());
      }

      sb.append("\n");
    }

    System.out.println(sb);
  }
}
