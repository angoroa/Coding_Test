import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        // 0, 1, 3, 5, 6
        // 6, 5, 3, 1, 0
        // 6: 6 (1)
        // 5: 6,5 (2)
        // 3: 6,5,3 (3)
        // 1: 6,5,3,1, (4)
        // 0: 6,5,3,1,0 (5)
        int answer = 0;
        for(int i= citations.length-1; i>=0; i--){
            int count = citations.length - i;
            // 1 = 5 - 4
            // 2 = 5 - 3
            //
            
            if (citations[i] >= count){
                answer = count;
            }
        }
        return answer;
    }
}