import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 10 ^ 11 % 12
        // 1 * 1 * 1 * 1 * 1 % 2 = 1
        // 3 * 3 * 3 * 3 * 3 % 2 = 1
        
        // A * A * A * A * A % C
        // (A%C) * (A%C) * (A%C) * (A%C) % (A%C) % C
        // (A%C)를 B번
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long answer = answerfunc(A,B,C);
        System.out.println(answer);
    }
    static long answerfunc(long A, long B, long C){
        if(B == 1){
            return (A % C);
        }
        if(B == 0){
            return (1%C);
        }
        
        long half = answerfunc(A,B/2,C);
        
        if (B%2==0){
            //짝수
            return (half * half) %C % C;
        }
        else{
            //홀수
            return (half * half) % C * A % C;
        }           


            
    }
    
}