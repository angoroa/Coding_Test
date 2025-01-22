import java.util.*;
class Solution
{
    public int solution(String S)
    {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<S.length(); i++){
            if(stack.isEmpty() || !stack.isEmpty()&&(stack.peek() !=S.charAt(i))){
            stack.push(S.charAt(i));
            }
            else {
                stack.pop();
            }
            }
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}