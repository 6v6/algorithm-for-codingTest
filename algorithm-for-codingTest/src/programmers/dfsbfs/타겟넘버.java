package programmers.dfsbfs;

class Solution4 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public void dfs(int[] numbers, int target, int sum, int node){
        if(node == numbers.length){
            if(sum == target)
                answer++;
            return;
        }
        dfs(numbers, target, sum+numbers[node], node+1);
        dfs(numbers, target, sum-numbers[node], node+1);
    }
}
