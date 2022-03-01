package 베스트앨범;

import java.util.*;

class Solution2 {
    static Map<String, LinkedList<GenreInfo>> map = new HashMap<String, LinkedList<GenreInfo>>();
    static Map<String, Integer> sumMap = new HashMap<String, Integer>();

    static class GenreInfo extends Genre {
        int num;

        public GenreInfo(int play, String genre, int num){
            super(play, genre);
            this.num = num;
        }
    }

    static class Genre {
        String genre;
        int play;

        public Genre(int play, String genre){
            this.play = play;
            this.genre = genre;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        // input
        for(int i = 0; i < genres.length; i++){
            LinkedList<GenreInfo> list = map.getOrDefault(genres[i], new LinkedList<GenreInfo>());
            list.push(new GenreInfo(plays[i], genres[i], i));
            map.put(genres[i], list);

            int playSum = sumMap.getOrDefault(genres[i], 0) + plays[i];
            sumMap.put(genres[i], playSum);
        }

        Iterator it = sumMap.entrySet().iterator();
        LinkedList<Genre> list = new LinkedList<Genre>();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
            list.push(new Genre(entry.getValue(), entry.getKey()));
        }

        //sort
        list.sort((o1, o2) -> o2.play - o1.play);

        LinkedList<Integer> result = new LinkedList<Integer>();
        for(int i = 0; i < list.size(); i++){
            LinkedList<GenreInfo> genreList = map.get(list.get(i).genre);
            genreList.sort((o1, o2) -> (o2.play == o1.play) ? (o1.num - o2.num) : (o2.play - o1.play));

            result.offer(genreList.get(0).num);

            if(genreList.size() > 1){
                result.offer(genreList.get(1).num);
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }


}
