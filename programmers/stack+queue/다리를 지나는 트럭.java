import java.util.*;
class Solution {
    class Truck{
        int truck_weight;
        int truck_enter_time;
        public Truck(int truck_weight,int truck_enter_time){
            this.truck_weight = truck_weight;
            this.truck_enter_time = truck_enter_time;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> wait = new LinkedList<Truck>(); //기다리는 트럭
        Queue<Truck> bridge = new LinkedList<Truck>(); //다리 위 트럭
        Queue<Truck> finish_bridge = new LinkedList<Truck>(); //도착
        
        for(int i = 0; i<truck_weights.length; i++){
            wait.add(new Truck(truck_weights[i],0));
        }
        
        int totalTime = 0;
        int i = 0;
        int curWeight = 0;
        Truck truck;
        
        while(finish_bridge.size() != truck_weights.length){
            totalTime++;
            if(bridge.isEmpty()){ //다리가 비었으면
                truck = wait.poll();
                truck.truck_enter_time = totalTime;
                bridge.add(truck);
                curWeight += truck.truck_weight;
            }else{
           if(totalTime - (bridge.peek().truck_enter_time)==bridge_length){//트럭이 도착했을 때
                    truck = bridge.poll();
                    finish_bridge.add(truck);
                    curWeight -= truck.truck_weight;
            }
            if(!wait.isEmpty() && weight-curWeight>=wait.peek().truck_weight){//무게가 여유 있을 때 
                    truck = wait.poll();
                    truck.truck_enter_time = totalTime;
                    bridge.add(truck);
                    curWeight += truck.truck_weight;
            }
            }
               
            }
        answer = totalTime;
        return answer;
    }
}