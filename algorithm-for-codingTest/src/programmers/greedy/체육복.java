class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] fullArray = new int[n];
        
        //크기가 n인 배열을 모두 1로 초기화
        for(int i = 0; i <n; i++){
            fullArray[i] = 1;
        }
    
        //도난당한 경우 0으로
        for (int i : lost){
            fullArray[i-1]--;
        }
        
        //여유가 있을 경우 +1
        for (int i : reserve){
            fullArray[i-1]++;
        }
        
        for(int i = 0; i <n; i++){
            if(fullArray[i] > 1){
                if(i > 0){
                    if(i == n-1){ //맨 끝 인덱스이면
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
