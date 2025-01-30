import java.util.*;
class Solution {
    public int[] solution(String result) {
        int count=0;
        int countZero=0;
        while(!result.equals("1")){
            StringBuilder sb2 = new StringBuilder();
            for(int i=0; i<result.length(); i++){
                if(result.charAt(i)=='0') countZero++;
                else{
                    sb2.append(result.charAt(i));
                }
                }
            result = sb2.toString();
            int c = result.length();
            Deque <Integer> deque = new ArrayDeque<>();
            
            while(c!=0){
                deque.addFirst(c%2);
                c = c/2;
            }
            StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()){
                sb.append(""+deque.pollFirst());
            }
            result = sb.toString();
            count++;
        }
        int answer[] = new int[2];
        answer[1] =countZero;
        answer[0] =count;
        return answer;
    }
}