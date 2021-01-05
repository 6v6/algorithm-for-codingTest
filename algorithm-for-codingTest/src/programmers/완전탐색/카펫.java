package programmers.완전탐색;
class Solution3 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //珥� ���씪�쓽 �닔
        int total = brown + yellow;
        int horizontal, vertical;
        
        for(int i = 3; i*i <= total; i++){
            if(total % i == 0){
                horizontal = total/ i; //媛�濡�
                vertical = i; //�꽭濡�
                int browncheck = horizontal*2 + (vertical-2)*2;
                if(brown == browncheck){
                    answer[0] = horizontal;
                    answer[1] = vertical;
                    return answer;
                }
            }
        }
        
        
        return answer;
    }
}
