package programmers.stackqueue;

import java.util.*;
class Solution2 {
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
        Queue<Truck> wait = new LinkedList<Truck>(); //湲곕떎由щ뒗 �듃�윮
        Queue<Truck> bridge = new LinkedList<Truck>(); //�떎由� �쐞 �듃�윮
        Queue<Truck> finish_bridge = new LinkedList<Truck>(); //�룄李�
        
        for(int i = 0; i<truck_weights.length; i++){
            wait.add(new Truck(truck_weights[i],0));
        }
        
        int totalTime = 0;
        int i = 0;
        int curWeight = 0;
        Truck truck;
        
        while(finish_bridge.size() != truck_weights.length){
            totalTime++;
            if(bridge.isEmpty()){ //�떎由ш� 鍮꾩뿀�쑝硫�
                truck = wait.poll();
                truck.truck_enter_time = totalTime;
                bridge.add(truck);
                curWeight += truck.truck_weight;
            }else{
           if(totalTime - (bridge.peek().truck_enter_time)==bridge_length){//�듃�윮�씠 �룄李⑺뻽�쓣 �븣
                    truck = bridge.poll();
                    finish_bridge.add(truck);
                    curWeight -= truck.truck_weight;
            }
            if(!wait.isEmpty() && weight-curWeight>=wait.peek().truck_weight){//臾닿쾶媛� �뿬�쑀 �엳�쓣 �븣 
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