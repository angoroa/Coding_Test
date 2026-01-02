import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        // 1 2 3 4 5 6 7 -> 3
        // 4 5 6 7 1 2 -> 6
        // 7 1 2 4 5 -> 2
        // 4 5 7 1 -> 7 
        // ....
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=num; i++){
            list.add(i);
        }
        int index = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(!list.isEmpty()){
            index = (index + target -1) % list.size(); 
            sb.append(list.remove(index));
            if(!list.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.print(sb);
    }
}