import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String,Integer> map = new HashMap<>();
        // for(int i=0; i<phone_book.length; i++){
        //     map.put(i,phone_book[i]);
        // }
        for(String p:phone_book){
            map.put(p,1);
        }
        for(String p : phone_book){
            for(int i=1; i<p.length(); i++){
                if(map.containsKey(p.substring(0,i))) return false;
            }
    }
    return true;

    }

}