import java.util.*;
class Solution
{
    public int solution(String S)
    {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<S.length(); i++){
            if (stack.isEmpty()) stack.push(S.charAt(i));
            else if(stack.peek() == S.charAt(i)) stack.pop();
            else {
                stack.push(S.charAt(i));
            }
            }
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}