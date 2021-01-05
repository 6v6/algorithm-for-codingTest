package programmers.greedy;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] fullArray = new int[n];
        
        //�겕湲곌� n�씤 諛곗뿴�쓣 紐⑤몢 1濡� 珥덇린�솕
        for(int i = 0; i <n; i++){
            fullArray[i] = 1;
        }
    
        //�룄�궃�떦�븳 寃쎌슦 0�쑝濡�
        for (int i : lost){
            fullArray[i-1]--;
        }
        
        //�뿬�쑀媛� �엳�쓣 寃쎌슦 +1
        for (int i : reserve){
            fullArray[i-1]++;
        }
        
        for(int i = 0; i <n; i++){
            if(fullArray[i] > 1){
                if(i > 0){
                    if(i == n-1){ //留� �걹 �씤�뜳�뒪�씠硫�
                      if (fullArray[i-1] == 0){
                        fullArray[i-1]++;
                        fullArray[i]--;
                    }
                    }
                    else{
                        if (fullArray[i-1] == 0){
                            fullArray[i-1]++;
                            fullArray[i]--;
                        }
                        else if(fullArray[i+1] == 0){
                            fullArray[i+1]++;
                            fullArray[i]--;
                        }
                    }
                }
            }
        }
        int answer = 0;
        for(int i = 0; i <n; i++){
            if(fullArray[i] > 0)
                answer++;
        }
        return answer;
    }
        
}
