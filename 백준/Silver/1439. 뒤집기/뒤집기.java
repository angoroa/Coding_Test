import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int zero = 0;
        int one = 0;
        
        // 첫 문자로 초기 그룹 설정
        if(input.charAt(0) == '1') one++;
        else zero++;
        
        for(int i=1; i<input.length(); i++){
            if (input.charAt(i) != input.charAt(i-1)){
                if(input.charAt(i) == '1') one++;
                else zero++;
            }
        }
        
        System.out.println(Math.min(zero,one));
        
        
        
       
    }
}
