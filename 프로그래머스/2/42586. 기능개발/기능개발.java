import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int days[] = new int[progresses.length];
        for (int i=0; i<progresses.length; i++){
            days[i] =  (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
            // ex. 100 - 93 = 7 / speeds (1) = 7일
            // ex. 100 - 30 = 70 / speeds (30) = 2.7일 => 3일
            queue.add(days[i]);
        }
        while(!queue.isEmpty()){
            int baseDay = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && queue.peek()<=baseDay){
                count ++;
                queue.poll();
            }
            answer.add(count);
        }
        return answer;
        
    }
    
}