import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        int total = 0;
        
        for(int i=0; i<N; i++){
                sum += arr[i];
                total +=sum;
            // sum = arr[0], total = arr[0]
            // sum = arr[0] + arr[1], total = arr[0] + (arr[0] + arr[1])
            // sum = arr[0] + arr[1] + arr[2], total = arr[0] + arr[0] + arr[1] + arr[0] + arr[1] + arr[2] + 
            // sum = arr[0] + arr[1] + arr[2] + arr[3]    
        }
        System.out.print(total);
    }
}
