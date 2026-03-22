import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        int B[] = new int[N];
        int sum = 0;
        
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);
        Arrays.sort(A);
        for(int i=0; i<N; i++){
            sum += A[N-1-i] * B[i];
        }
        System.out.print(sum);
    }
}
