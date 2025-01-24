import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String success = "Yes";
        String fail = "No";
        int i=0;
        Queue <String> queue1 = new ArrayDeque<>();
        Queue <String> queue2 = new ArrayDeque<>();
        Queue <String> goals = new ArrayDeque<>();
        for(String s: cards1){
            queue1.add(s);
        }
        for(String s: cards2){
            queue2.add(s);
        }
        for(String s: goal){
            goals.add(s);
        }
        while(i<goal.length){
            if (!queue1.isEmpty()&&queue1.peek().equals(goals.peek())){
                queue1.poll();
                goals.poll();
            }
            else if(!queue2.isEmpty()&&queue2.peek().equals(goals.peek())){
                queue2.poll();
                goals.poll();
            }
            i++;
        }
        if (!goals.isEmpty()) return fail;
        return success;
    }
}