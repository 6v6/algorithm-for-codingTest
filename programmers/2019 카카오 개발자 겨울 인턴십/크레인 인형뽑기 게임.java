import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<Integer>();
        int moveNum=0;
        int i, j;
        for(i=0; i<moves.length; i++){
            for(j=0; j<board.length; j++){
                moveNum = board[j][moves[i]-1];
                if(moveNum!=0){
                    board[j][moves[i]-1]=0;
                    break;
                }
            }
            if(moveNum!=0){
            if(!st.empty()){
                int peak = st.pop();
                if(peak==moveNum){
                    answer=answer+2;
                }
                else{
                    st.push(peak);
                    st.push(moveNum);
                }
            }
            else
                st.push(moveNum);
             }
        }
        while(!st.empty()){
        System.out.println(st.pop());
        }
        return answer;
    }
}