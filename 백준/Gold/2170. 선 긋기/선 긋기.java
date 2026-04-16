import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 무조건 정렬하기
       //1 2 3 4 5 6 7
       // 안에 포함 되면: 끝이 바뀜
       // 안에 포함 X: sum = sum + b -a;
       int N = Integer.parseInt(br.readLine());
       int arr[][] = new int[N][2];
       for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine());
               arr[i][0] = Integer.parseInt(st.nextToken());
               arr[i][1] = Integer.parseInt(st.nextToken());
           }
               Arrays.sort(arr, (a,b)->{
           if(a[0] == b[0]){
               return a[1] - b[1];
           }
           return a[0] - b[0];
       });
       int start = arr[0][0];
       int end = arr[0][1];
       long sum = 0;
      for(int i=1; i<N; i++){
              if (arr[i][0] <= end){
                  end = Math.max(end, arr[i][1]);
              }
              else{
                  sum += end - start;
                  start = arr[i][0]; 
                  end = arr[i][1];
              }
      }
              sum += end - start;
        
      System.out.print(sum);
       
    }
       }


