package 신고결과받기;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 1. Map을 이용하여 <이름, 신고한 유저 셋> 만들기
        Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        Map<String, Integer> idxMap = new HashMap<String, Integer>();


        for(int i = 0; i < id_list.length; i++) {
            idxMap.put(id_list[i], i);
        }

        // 2. report를 파싱하여 <이름, 신고한 유저 셋> 값넣기
        for(String str : report) {
            String[] values = str.split(" ");
            HashSet<String> hashSet = map.getOrDefault(values[0], new HashSet<String>());
            hashSet.add(values[1]);
            map.put(values[0], hashSet);
        }


        // 3. 신고당한 횟수 map을 하나 씩 읽어보며 블랙리스트 문자열 배열을 만든다.
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String, HashSet<String>> entry = (Map.Entry<String, HashSet<String>>) it.next();
            Set<String> hashSet = entry.getValue();
            List<String> list = new LinkedList<String>(hashSet);
            for(String str : list){
                countMap.put(str, countMap.getOrDefault(str, 0) + 1);
            }
        }

        Set<String> blackList = new HashSet<String>();
        set = countMap.entrySet();
        it = set.iterator();

        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
            if(entry.getValue() >= k){
                blackList.add(entry.getKey());
            }
        }


        // 4. <이름, 신고한 유저 리스트>를 읽어보며 정답 배열을 만들어서 신고한 유저리스트를 체크하고 값을 넣는다.
        int[] result = new int[id_list.length];
        set = map.entrySet();
        it = set.iterator();

        while(it.hasNext()){
            Map.Entry<String, HashSet<String>> entry = (Map.Entry<String, HashSet<String>>) it.next();

            String key = entry.getKey();
            Set<String> hashSet = entry.getValue();

            for(String str : blackList){
                if(hashSet.contains(str)){
                    result[idxMap.get(key)]++;
                }
            }
        }

        return result;
    }
}