import java.util.*;
class Solution {
    
    public int solution(String s) {
                    int answer = s.length();


        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, len);
            int count = 1;
 

  
            for (int i = len; i < s.length(); i += len) {
                String chunk = s.substring(i, Math.min(i + len, s.length()));

                if (chunk.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }

                    sb.append(prev);
                    prev = chunk;
                    count = 1;
                }
            }
            if (count >1) sb.append(count);
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}