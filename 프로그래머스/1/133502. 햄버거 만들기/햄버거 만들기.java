import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        Stack <Integer> stack = new Stack<>();
        int count = 0;
        for(int i: ingredient){
            stack.push(i);
            if(stack.size()>=4){
                int SIZE = stack.size();
                if(stack.get(SIZE-4)==1&&
                   stack.get(SIZE-3)==2&&
                   stack.get(SIZE-2)==3&&
                   stack.get(SIZE-1)==1
                  ){
                    stack.pop();
                    stack.pop();
                    stack.pop();
                     stack.pop();
                    count++;
            }
            }
        }
        return count;
        }

    }
  