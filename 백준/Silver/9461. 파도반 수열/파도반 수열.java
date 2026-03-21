import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long dp[];
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            dp = new long[N+1];
            if(N>=1 && N<=3){
                    System.out.println(1);
                    continue;
            }
            else if(N==4){
                    System.out.println(2);
                    continue;
            }
            dp[0] = 0;
            dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2;
            for(int j=5; j<=N; j++){
                dp[j] = dp[j-1] + dp[j-5];
            }
            System.out.println(dp[N]);
            // 1,1,1,2,2,3,4,5,7,9
            // 
            // 1,1,1,2,2,3,4,5,7,9
            
            // dp[11] = dp[10]+dp[6];
            // dp[10] = dp[9]+dp[5];
            // dp[9] = dp[8]+dp[4];
            // dp[8] = dp[7]+dp[3];
            // dp[7] = dp[6]+dp[2];
            // dp[6] = dp[5]+dp[1];
            // dp[5] = dp[4]+dp[0];
            
        }
    }
}
