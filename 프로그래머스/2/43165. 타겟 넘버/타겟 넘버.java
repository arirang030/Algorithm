class Solution {
    
    int answer = 0;
    
    public void dfs(int[] numbers, int ind, int target, int sum) {
        
        if (ind == numbers.length && sum == target) {
            answer++;
            return;
        } else if (ind == numbers.length) return;
        
        dfs(numbers, ind+1, target, sum + numbers[ind]);
        dfs(numbers, ind+1, target, sum - numbers[ind]);  
        
        return;
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
}