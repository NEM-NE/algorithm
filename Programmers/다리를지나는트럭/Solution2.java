package 다리를지나는트럭;

import java.util.*;
import java.util.stream.Collectors;

class Solution2 {
    static LinkedList<Truck> queue = new LinkedList<Truck>();
    static int endCnt = 0;
    static class Truck {
        int weight;
        int time;

        public Truck(int weight){
            this.weight = weight;
            this.time = 0;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int idx = 0;
        int time = 1;
        while(endCnt != truck_weights.length){

            if(idx < truck_weights.length && (queue.size() < bridge_length && getWeightSum() + truck_weights[idx] <= weight)) {

                Truck newTruck = new Truck(truck_weights[idx++]);
                queue.offer(newTruck);
            }

            queue = moveTruck();
            queue = checkEnd(bridge_length);

            time++;
        }

        return time;
    }

    private static int getWeightSum(){
        int sum = 0;
        for(Truck truck : queue){
            sum += truck.weight;
        }

        return sum;
    }

    private static LinkedList<Truck> moveTruck() {
        return queue.stream().peek(truck -> truck.time += 1).collect(Collectors.toCollection(LinkedList::new));
    }

    private static LinkedList<Truck> checkEnd(int maxTime){
        LinkedList<Truck> list = queue.stream().filter(truck -> truck.time < maxTime).collect(Collectors.toCollection(LinkedList::new));
        endCnt += queue.size() - list.size();
        return list;
    }

}
