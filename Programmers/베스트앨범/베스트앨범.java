package 베스트앨범;

import java.util.*;

class Solution {
    static class Play{
        int plays;
        int index;

        public Play(int plays, int index){
            this.plays = plays;
            this.index = index;
        }
    }
    
    // 12 : 24 30분
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        LinkedList<Integer> ans = new LinkedList<Integer>();
        
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        while(map.size() != 0){
            //find Max key
            Set set = map.entrySet();
            
            Iterator it = set.iterator();
            int max = 0;
            String key = "";
            while(it.hasNext()){
                Map.Entry<String, Integer> entry 
                    = (Map.Entry<String, Integer>) it.next();
                if(max < (Integer)entry.getValue()){
                    max = (Integer)entry.getValue();
                    key = (String)entry.getKey();
                }
            }
            
            // 최대값 삭제하기
            map.remove(key);
            
            //맥시멈 장르 순서로 넣기
            ArrayList<Play> list = new ArrayList<Play>();
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(key)){
                    Play play = new Play(plays[i], i);
                    list.add(play);
                }
            }
            
            Collections.sort(list, new Comparator<Play>(){
                public int compare(Play o1, Play o2){
                    return o2.plays - o1.plays;
                }
            });
            
            ans.add(list.get(0).index);
            if(list.size() > 1)ans.add(list.get(1).index);
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
