package programmers.sort;
import java.util.*;
class Solution1 {
    public String solution(int[] numbers) {
        
        String[] nums = new String[numbers.length];
        String answer = "";
        
        for(int i = 0; i < numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        if(nums[0].equals("0")){
            return "0";
        }
        else{
            for(int i =  0; i < nums.length; i++){
                answer += nums[i];
            }
        }
        
        return answer;
    }
}
