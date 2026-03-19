import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];
        // dp[i] : 2xi를 채우는 방법의 수
        dp[0] = 1; dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            // 마지막에 하면 늦는다 DP 중간에 mod를 넣어준다.
            // 오버플로 방지하게 하기 위해서
            // 값을 작게 유지하기 위해서
            
        }
        System.out.println(dp[n]);
    }
}
