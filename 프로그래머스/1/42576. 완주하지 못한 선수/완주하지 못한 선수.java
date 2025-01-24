import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashSet = new HashMap<>();
        String value = null;
        for(String s:participant){
            if(hashSet.containsKey(s))
            hashSet.compute(s, (k, v) -> v + 1);
            else{
                hashSet.put(s, 1);
            }
        }
        for(String s:completion){
            if(hashSet.get(s)==1)
            hashSet.remove(s);
            else{
                hashSet.compute(s,(k,v)->v-1);
            }
        }
        for(String s:hashSet.keySet()){
            value = s;
            break;
        }
        return value;
    }
}