import java.io.*;
import java.util.*;

public class Main{
    static Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
    // 입력용 BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

    String[] input = br.readLine().split(" ");
    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    int num;
    // 1, 2, 3, 4, 5, 6, 7
    // 1, 2,    4, 5, 6, 7
    // 1, 2,    4, 5,    7  
    // 1,       4, 5,    7          
    for(int i=1; i<=a; i++){
        queue.offer(i);
    }
    System.out.print("<");
    while(!queue.isEmpty()){
        yosay(b);
        System.out.print(queue.poll());
        if (!queue.isEmpty()){
            System.out.print(", ");            
        }

    }        
    System.out.print(">");        
    }
    static void yosay(int b){
        int res;
        for (int i=0; i< b-1; i++){
            res = queue.poll();
            queue.add(res);          
        }

    }
        
}
