import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        // LRU
        LinkedList<String> list = new LinkedList<>();
        int count = 0;
                        if (cacheSize == 0) return cities.length * 5;
        for(String s: cities){
                s = s.toLowerCase();
                // hit
                if(list.contains(s)){
                list.remove(s);
                list.add(s);
                count++;
                }
                // miss
                else {
                    if(list.size() >= cacheSize) list.remove();
                    
                list.add(s);
                count+=5;
                }           
            

            
        }
        return count;
        }
}
