 import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       Deque<Integer> dque = new ArrayDeque<>();
       for(int i=1; i<=N; i++){
           dque.addLast(i);
       }
       st = new StringTokenizer(br.readLine());
       int answer = 0;
       for(int i=0; i<M; i++){
           int Lcount = 0;
           int Rcount = 0;
           int target = Integer.parseInt(st.nextToken());
           // 2일 때 코드:
           int idx = 0;
           for (int x : dque){
               if(x == target) break;
               Lcount++;
           }
           
           // 3일 때 코드:
           Rcount = dque.size() - Lcount;
           
           if (Lcount <= Rcount){
               for(int j=0; j <Lcount; j++){
                   dque.addLast(dque.pollFirst());
               }
           }
           else{
               for(int j=0; j <Rcount; j++){
                   dque.addFirst(dque.pollLast());
               }
           }
           answer +=Math.min(Lcount, Rcount);
           dque.pollFirst();
       }
       System.out.println(answer);
       // 1. 첫번째 원소: pollFirst()
       // 2. 왼쪽으로 한 칸 이동: pollFirst() & addLast()
       // 3. 오른쪽으로 한 칸 이동: pollLast() & addFirst()
   }
}