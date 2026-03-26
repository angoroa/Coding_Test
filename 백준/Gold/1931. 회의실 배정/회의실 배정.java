import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        StringTokenizer st;
        
        for(int[] a: arr){
            st = new StringTokenizer(br.readLine());
            a[0] = Integer.parseInt(st.nextToken());
            a[1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a,b)->{
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int count = 0;
        int end = 0;
        for(int[] a: arr){
            int start = a[0];
            int finish = a[1];
            
            if(start>=end){
                end = finish;
                count++;
            }
        // end = 4, (3,5)
        // end = 4, (5,7)
        }
        System.out.println(count);
        
    }
}
