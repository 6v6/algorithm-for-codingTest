package Greedy;

public class joystick {
	public int solution(String name) {
        int result = 0;
        int length = name.length();
        
        //���ĺ� ��ȯ �ּ�
        for(int i =  0; i < length; i++){
            Character target = name.charAt(i);
            if(target != 'A'){
               if(target - 'A' <= 'Z'-target+1) 
                   result += target - 'A';
                else
                    result += 'Z'-target+1;     
            }
        }
               
        //�̵� �� �ּ�
        int minMove = length;
        for(int i =  0; i < length; i++){
            if(name.charAt(i) != 'A'){
                int next = i+1;
                while(next < length && name.charAt(next) == 'A'){
                    next++;
                }
                int move = 2 * i + length - next;
                if(minMove > move)
                    minMove = move; 
            }
        }
        result += minMove;
        return result;
    }
}
