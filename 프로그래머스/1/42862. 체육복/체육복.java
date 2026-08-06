import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // [2,4] [1, 3, 5]
        // 1. 정렬
        // 2. 여벌인데 도난당한 학생 처리
        // 3. for문으로 빌려주기
        // 4. return
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i=0; i<lost.length; i++){
            for (int j=0; j<reserve.length; j++){
                if (lost[i] == reserve[j]){
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }
        for (int i=0; i<lost.length; i++){
            if(lost[i] == -1) continue;
            for(int j=0; j<reserve.length; j++){
                if (reserve[j] == -1) continue;
                if (reserve[j] == lost[i]-1 || reserve[j] == lost[i]+1){
                    reserve[j] = lost[i] = -1;
                    break;
                }
            }
        }
        int count = 0;
        for(int i=0; i<lost.length; i++){
            if(lost[i]!=-1) count++;
        }
        return n - count;

    }
}