package 주식가격;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    static class Item {
        int idx, price, time;

        public Item(int idx, int price){
            this.idx = idx;
            this.price = price;
            this.time = 1;
        }
    }
    static Queue<Item> queue = new LinkedList<Item>();
    static int[] answer;
    public static int[] solution(int[] prices) {
        answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            Item item = new Item(i, prices[i]);
            queue = valid(item); // 큐 내부 아이템의 타당성 확인
        }

        for(Item item : queue){
            answer[item.idx] = item.time - 1;
        }

        answer[prices.length-1] = 0;

        return answer;
    }

    public static Queue<Item> valid(Item newItem){
        Queue<Item> temp = new LinkedList<Item>();
        int size = queue.size();
        for(int i = 0; i < size; i++){
            Item item = queue.poll();

            if(item.price <= newItem.price){
                item.time++;
                temp.offer(item);
            }else {
                answer[item.idx] = (item.time > 1) ? item.time - 1 :item.time;
            }
        }

        temp.offer(newItem);
        return temp;
    }

    public static void main(String[] args) {
        int[] result = Solution2.solution(new int[]{1, 2, 3, 2, 3});
        for(int num : result){
            System.out.println(num);
        }
    }
}
