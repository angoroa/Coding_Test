import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum =0;
            int count =0;
            for (int t:tangerine){
                map.put(t, map.getOrDefault(t,0)+1);
            }
            List<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list, Collections.reverseOrder());
            for (int i=0; i<list.size(); i++){
                sum+=list.get(i);
                count++;
                if(sum >=k) return count;

        }
        return count;

        
    }
}