import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int sum = 0;
        
        int awsleft = -1;
        int awsright = -1;
        for(int right = 0; right < sequence.length; right++){
            sum += sequence[right];
            
            while(sum > k){
                sum -= sequence[left++];
            }
            
            if(sum == k){
                int curlen = right - left;
                int awslen = awsright - awsleft;
                
                if(awsleft == -1 || curlen < awslen){
                    awsleft = left;
                    awsright = right;
                }
                
            }
        }
        return new int[]{awsleft,awsright};
    }
}