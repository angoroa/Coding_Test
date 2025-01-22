import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int [] pricesCount = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            int pivot = prices[i];
            for(int j=i+1; j<prices.length; j++){
                    pricesCount[i]++;
                if(pivot > prices[j]) break;
            }
        }
            return pricesCount;
        
    }
}