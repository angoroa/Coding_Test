import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int [][] pattern = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        int [] scores = new int[3];
        // scores = {0,0,0} 초깃값이 0인 배열 생성
        
        for (int i=0; i<answers.length; i++){
            for (int j=0; j<pattern.length; j++){
                if(answers[i] == pattern[j][i%pattern[j].length]) scores[j]++;
            }
        }
        int maxScore = Arrays.stream(scores).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i< scores.length; i++){
            if(scores[i] == maxScore) list.add(i+1);
        }
        return list;                    
        
    }
}