package 다단계칫솔판매;//6:00
import java.util.*;

class Node {
    int amount;
    String name;
    Node parent;
    
    public Node(int amount, String name){
        this.amount = amount;
        this.name = name;
    }
    
    public void setParent(Node parent){
        this.parent = parent;
    }
    
    public void addAmount(int price){
        this.amount += price;
    }
}


class 다단계칫솔판매 {
    static Map<String, Node> map;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        map = new HashMap<String, Node>();
        
        //input
        for(int i = 0; i < enroll.length; i++){
            Node node = new Node(0, enroll[i]);
            map.put(enroll[i], node);
        }
        
        for(int i = 0; i < referral.length; i++){
            Node node = map.get(enroll[i]);
            Node parentNode = map.getOrDefault(referral[i], null);
            node.setParent(parentNode);
        }
        
        for(int i = 0; i < seller.length; i++){
            Node sellerNode = map.get(seller[i]);
            distributeProfit(sellerNode, amount[i] * 100);
        }
        
        int[] result = new int[enroll.length];
        for(int i = 0; i < result.length; i++){
            result[i] = map.get(enroll[i]).amount;
        }
        
        return result;
    }
    
    public static void distributeProfit(Node node, int profit){
        Node parentNode = node.parent;
        int parentNodeProfit = profit/10;
        node.addAmount(profit - parentNodeProfit);
        
        if(parentNode == null) return;
        distributeProfit(parentNode, parentNodeProfit);
    }
}