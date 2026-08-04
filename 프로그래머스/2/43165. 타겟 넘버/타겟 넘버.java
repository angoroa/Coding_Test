import java.util.*;

class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int depth=0;
        int sum =0;
        dfs(depth, sum,numbers,target);
        return count;
    }
    public void dfs(int depth, int sum, int[] numbers, int target){
        if (depth == numbers.length){
            if(sum == target)count++;
            // 숫자를 전부 썼다.
            
        } else {
            // 아직 숫자가 남았다. 더하거나 빼거나
            dfs(depth+1, sum + numbers[depth], numbers, target);
            dfs(depth+1, sum - numbers[depth], numbers, target);
        }
        
    }
}