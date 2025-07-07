import java.util.*;
class Solution {
    static class Truck {
        int weight;
        int endTime;
        
        Truck(int weight, int endTime){
            this.weight = weight;
            this.endTime = endTime;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        
        int time = 0;
        int totalWeight = 0;
        int idx = 0;
        
        while (idx < truck_weights.length || !bridge.isEmpty()){
            time++;
            
            // 트럭이 도착해서 다리에서 빠져 나가는 경우
            if (!bridge.isEmpty() && bridge.peek().endTime == time){
                totalWeight -= bridge.poll().weight;
            }
            
            // 다음 트럭을 다리 위에 올릴 수 있는 경우
            if (idx < truck_weights.length && totalWeight + truck_weights[idx] <= weight){
                int truckWeight = truck_weights[idx];
                totalWeight += truckWeight;
                bridge.offer(new Truck(truckWeight, time + bridge_length));
                idx++;
            }
        }
        return time;
    }
}