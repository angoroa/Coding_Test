import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            //
            
        
        long profit = 0;
        int max = 0;
        
        for(int j=N-1; j>=0; j--){
            if(arr[j] > max) max = arr[j];
            else{
                profit += max - arr[j];
            }
        }
            System.out.println(profit);
        }
        
       
    }
}
