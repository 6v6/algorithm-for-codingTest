package StackQueue;

import java.util.*;
class Solution4 {
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
        Queue<Truck> wait = new LinkedList<Truck>(); //疫꿸퀡�뼄�뵳�됰뮉 占쎈뱜占쎌쑏
        Queue<Truck> bridge = new LinkedList<Truck>(); //占쎈뼄�뵳占� 占쎌맄 占쎈뱜占쎌쑏
        Queue<Truck> finish_bridge = new LinkedList<Truck>(); //占쎈즲筌∽옙
        
        for(int i = 0; i<truck_weights.length; i++){
            wait.add(new Truck(truck_weights[i],0));
        }
        
        int totalTime = 0;
        int i = 0;
        int curWeight = 0;
        Truck truck;
        
        while(finish_bridge.size() != truck_weights.length){
            totalTime++;
            if(bridge.isEmpty()){ //占쎈뼄�뵳�덌옙 �뜮袁⑸�占쎌몵筌롳옙
                truck = wait.poll();
                truck.truck_enter_time = totalTime;
                bridge.add(truck);
                curWeight += truck.truck_weight;
            }else{
           if(totalTime - (bridge.peek().truck_enter_time)==bridge_length){//占쎈뱜占쎌쑏占쎌뵠 占쎈즲筌△뫚六쏙옙�뱽 占쎈르
                    truck = bridge.poll();
                    finish_bridge.add(truck);
                    curWeight -= truck.truck_weight;
            }
            if(!wait.isEmpty() && weight-curWeight>=wait.peek().truck_weight){//�눧�떯苡뜹첎占� 占쎈연占쎌� 占쎌뿳占쎌뱽 占쎈르 
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