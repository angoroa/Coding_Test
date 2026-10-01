import java.util.*;
class Solution {
    public String solution(String p) {
        // 균형잡힌 괄호 문자열 : (, )의 개수가 같다.
        // 올바른 괄호 문자열: (,)의 짝도 맞다.
        
        if (p.equals("")) return "";
        int lcount = 0;
        int rcount = 0;
        int idx = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '(') lcount++;
            else rcount++;
    
            if(lcount == rcount){
                idx = i;
                break;
            }
        }
        String u = p.substring(0, idx+1);
        String v = p.substring(idx+1, p.length());
        
        if(u.charAt(0)=='('){
            // 1단계부터 다시 수행      
            return u + solution(v);
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            
            String inner = u.substring(1,u.length()-1);
            
            for(int i=0; i<inner.length(); i++){
                if(inner.charAt(i) == '(') sb.append(')');
                    else sb.append('(');
            }
            
            return sb.toString();
                      
        }
    }
}