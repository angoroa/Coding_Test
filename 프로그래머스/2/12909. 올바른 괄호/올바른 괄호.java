import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (char i:s.toCharArray()){
            if (stack.isEmpty()&& i==')'){
                return false;
            }
            else if(!stack.isEmpty()&& i==')'){
                stack.pop();
            }
            else{
                stack.push(i);
            }     
        }
            if (stack.isEmpty()) return true;
            else return false;

    }
}