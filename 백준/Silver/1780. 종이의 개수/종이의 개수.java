import java.util.*;
import java.io.*;

public class Main{
        static int[][] arr;
        static int[] count = new int[3];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0,N);
        
        for(int i=0; i<count.length; i++){
            System.out.println(count[i]);
        }
    }
    static void divide(int x, int y, int size){
        int dx = x;
        int dy = y;
        int d = size / 3;
        
        // 0. size == 1 일 때
        if (size == 1){
                    switch(arr[x][y]){
                        case -1:
                            count[0]++;
                            break;
                        case 0:
                            count[1]++;
                            break;
                        case 1:
                            count[2]++;
                            break;
                    }
                    return;
        }
        // 1. 모두 같은 수 일 때
        if(isSame(dx,dy, size)){
            switch(arr[dx][dy]){
                case -1:
                    count[0]+=1;
                    break;
                case 0:
                    count[1]+=1;
                    break;
                case 1:
                    count[2]+=1;
                    break;
            }
            return;
        }            
        // 2. 다른 수 있을 때
        else{
        for(int i=0; i<3; i++){
            int nx = x + d*i;
            for(int j=0; j<3; j++){
                int ny = y + d*j;
             divide(nx,ny,d);
            }
        }            
        }

    }
    static boolean isSame(int x, int y, int size){
        int answer = arr[x][y];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                  if(answer != arr[x+i][y+j]) return false;
            }
        }
        return true;
    }
}