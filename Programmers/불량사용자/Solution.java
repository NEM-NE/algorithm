package 불량사용자;

//10:16 -> 11:35
import java.util.*;

public class Solution {

  static boolean[] used;
  static ArrayList<Set> sets = new ArrayList<>();

  public int solution(String[] user_id, String[] banned_id) {
    used = new boolean[banned_id.length];
    Set<String> set = new HashSet<>();

    dfs(user_id, banned_id, 0, set);

    return sets.size();
  }

  public void dfs(String[] user_id, String[] banned_id, int depth, Set set){
    // 끝까지 순회했으면 banlist 다 채웠는지 확인
    if(checkFill(set)) return;


    for(int i = depth; i < user_id.length; i++){
      ArrayList<Integer> enabledBanList = containsBanList(user_id[i], banned_id);
      if(enabledBanList.isEmpty()) continue;

      for(int j = 0; j < enabledBanList.size(); j++){
        if(!used[enabledBanList.get(j)]){
          used[enabledBanList.get(j)] = true;
          set.add(user_id[i]);
          dfs(user_id, banned_id, i + 1, set);
          set.remove(user_id[i]);
          used[enabledBanList.get(j)] = false;
        }
      }
    }
  }

  // ArrayList<Set>으로 모든 Set을 가지고 있기
  public boolean checkFill(Set set) {
    boolean allClear = true;
    for(int i = 0; i < used.length; i++){
      if(!used[i]) allClear = false;
    }

    if(!allClear) return false;

    if(sets.size() == 0){
      Set newSet = new HashSet();
      newSet.addAll(set);
      sets.add(newSet);
    }else {
      boolean isOk = true;

      for(int i = 0; i < sets.size(); i++){
        Set temp = sets.get(i);
        if(temp.equals(set)) isOk = false;
      }
      if(isOk){
        Set newSet = new HashSet();
        newSet.addAll(set);
        sets.add(newSet);
      }
    }
    return true;
  }

  public ArrayList<Integer> containsBanList(String str, String[] banned_id){
    ArrayList<Integer> list = new ArrayList<>();

    for(int i = 0; i < banned_id.length; i++){
      if(banned_id[i].length() != str.length()) continue;
      if(used[i]) continue; // 이미 banlist에 채워져있는 경우

      boolean isSame = true;

      for(int j = 0; j < banned_id[i].length(); j++){
        if(banned_id[i].charAt(j) == '*') continue;
        if(banned_id[i].charAt(j) != str.charAt(j)) isSame = false;
      }

      if(isSame) list.add(i);
    }

    return list;
  }
}