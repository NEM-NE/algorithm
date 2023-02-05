package B5076;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  private static Scanner scanner = new Scanner(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  /*
<a> </a> <b> </strong>
#
-> illegal

</strong>
#
-> illegal



   */

  public static void main(String[] args) {
    while(scanner.hasNext()){
      String str = scanner.nextLine();
      if (str.equals("#")){
        break;
      }

      String[] tags = str.split("<");
      Stack<String> stack = new Stack<>();
      // body, strong, /body, /strong
      boolean isValid = true;
      for(int i = 1; i < tags.length; i++){
        String tag = tags[i];

        //get TagName
        String tagName = getTagName(tag);

        // process way to each kind of tags
        if (tagName.startsWith("/")){
          if(stack.isEmpty()){ // prevent empty stack case
            isValid = false;
            break;
          }

          String prevTagName = stack.peek();
          if (!tagName.substring(1).equals(prevTagName)){
            isValid = false;
            break;
          }
          stack.pop();

        }else if(!tagName.contains("/>")){
          stack.add(tagName);
        }
      }
      if(!stack.isEmpty()){
        isValid = false;
      }

      if (isValid){
        sb.append("legal").append("\n");
      }else {
        sb.append("illegal").append("\n");
      }
    }

    System.out.println(sb);

  }

  public static String getTagName(String str){
    if(str.startsWith("/")){ // 끝나는 경우
      int closeIdx = str.indexOf(">");
      return str.substring(0, closeIdx);
    }else if(str.trim().endsWith("/>")){ // 혼자 끝나는 경우
      return str;
    }else { // 시작하는 경우
      int closeIdx = str.indexOf(">");
      return str.substring(0, closeIdx).split(" ")[0];
    }
  }
}
