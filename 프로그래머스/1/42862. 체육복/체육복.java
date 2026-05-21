import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // [2,4] [1, 3, 5]
        // 1
        // 
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int count =0;

        for (int i=0; i<lost.length; i++){
            for (int j=0; j<reserve.length; j++){
                if (lost[i] == reserve[j]){
                    lost[i] = reserve[j] = -1;
                }
            }
        }
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] > 0 && reserve[j] > 0 && (lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1)){ lost[i] = -1;
                  reserve[j] = -1;
                   break;
                                                                                                          }                  
                  
            }
        }
        for(int i=0; i<lost.length; i++){
            if(lost[i] > 0) count++;
        }
        return n - count;
    }
}