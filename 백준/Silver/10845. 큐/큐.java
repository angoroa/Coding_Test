import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        LinkedList<Integer> que = new LinkedList<>();
        String cmd;
        for(int i=0; i< num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            switch(cmd){
                case "push":
                    int cmd2 = Integer.parseInt(st.nextToken());
                    que.add(cmd2);
                    break;

                case "pop":
                    if(que.isEmpty()) System.out.println(-1);
                    else {
                    System.out.println(que.poll());
                    }
                    break;

                    
                case "front":
                    if(que.isEmpty()) System.out.println(-1);
                    else{
                        System.out.println(que.peek());
                        
                    }
                    break;
                    
                case "back":
                    if(que.isEmpty()) System.out.println(-1);
                    else{
                        System.out.println(que.getLast());
                    }
                    break;
                case "size":
                    System.out.println(que.size());
                    break;
                case "empty":
                    if(que.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                 
                    break;
            }
        }
    }
}