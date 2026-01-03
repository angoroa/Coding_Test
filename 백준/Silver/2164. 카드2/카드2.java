import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<= num; i++){
            queue.add(i);
        }
        // 1. 맨 위에 있는 거 버림(poll)
        // 2. 맨 뒤에다가 삽입(add)
        int target;
        while(queue.size()!=1){
            queue.poll();
            target = queue.poll();
            queue.add(target);
        }
        int answer = queue.poll();
        System.out.println(answer);
    }
}