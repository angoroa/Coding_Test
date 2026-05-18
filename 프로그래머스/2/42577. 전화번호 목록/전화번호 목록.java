import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
    Set<String> set = new HashSet<>();
    for(int i=0; i<phone_book.length; i++){
        set.add(phone_book[i]);
    }
    for(String s: set){
        for(int i=0; i<s.length()-1; i++){
            if(set.contains(s.substring(0,i+1))) return false;

        }
    }
    return true;
}
}