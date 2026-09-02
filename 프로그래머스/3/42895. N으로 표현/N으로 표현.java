import java.util.*;
class Solution {
    public int solution(int N, int number) {
        Set<Integer> dp[] = new HashSet[9];
        for(int i=1; i<9; i++){
            dp[i] = new HashSet<>();
        }
        dp[1].add(N);
        for (int i=2; i<9; i++){
            
            for(int j=1; j<i; j++){
                
                for(Integer a: dp[j]){
                    for(Integer b: dp[i-j]){
                        dp[i].add(a+b);
                        dp[i].add(a-b);
                        dp[i].add(a*b);
                        if(b!=0) dp[i].add(a/b);
                    }
                }
                
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i; j++){
                sb.append(N);
            }
            dp[i].add(Integer.parseInt(sb.toString()));
        }
        for(int i=1; i<9; i++){
            for(Integer d: dp[i]){
                if (d.equals(number)) return i;
            }
        }
        return -1;
    }
}