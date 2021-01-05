package BF;

class Solution3 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //�룯?���? ?��?��?��?��?��뵬占?���? ?��?��?��
        int total = brown + yellow;
        int horizontal, vertical;
        
        for(int i = 3; i*i <= total; i++){
            if(total % i == 0){
                horizontal = total/ i; //?��?��?��?��?��?��
                vertical = i; //?��?��?��?��?��?��
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
