import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 3 2 6 => 5 5 6 => 16S
        // 1 2 3 4 => 3 3 3 4 => 6 6 3 4 => 19
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long total = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int i=0; i<n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }
        for (int i=0; i<m; i++){
            long a = pq.poll();
            long b = pq.poll();
            long sum = a+b;
            
            pq.add(sum);
            pq.add(sum);
        }
        for (Long x : pq){
            total += x;
        }

        System.out.print(total);
    }
}