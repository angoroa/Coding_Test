import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int left = 0;
        int right = people.length-1;
        int count=0;
        Arrays.sort(people);
        
        while(left<=right){
            if(people[left]+people[right]<=limit)             {
                left++;
                right--;
                // 여기에서 이제 left가 줄어들지 right가 줄어들디 2갈래 분기?
            }
            else{
                right--;
            }
            count++;
        }
        
        return count;
    }
}