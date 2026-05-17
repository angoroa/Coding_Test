  import java.util.*;
class Solution {
    public int solution(int[] nums) {
                // Set<Integer> set = new TreeSet<>(); : 자동 정렬됨
        // Set<Integer> set = new LinkedHashSet<>(); : 넣은 순서 유지
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        
        
        return Math.min(set.size(), nums.length/2);
        
    }
}