import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> JH = new HashMap<>();
        HashMap<String, Integer> Mart = new HashMap<>();
        int count = 0;
        // getOrDefault(key, 기본값)
        // : key로 값을 꺼내되, 앖으면 기본값
        for(int i=0; i< want.length; i++){
            JH.put(want[i], number[i]);
            // {"바나나": 3, "사과":2, "밥":2, "돼지":1, "냄비":1}
        }
        for(int i=0; i< 10; i++){
            Mart.put(discount[i], Mart.getOrDefault(discount[i], 0)+1);
        }
        
        if (JH.equals(Mart)) count++;
        
        for(int i=0; i<discount.length - 10; i++){
            // 앞에 꺼 빼기
            Mart.put(discount[i], Mart.get(discount[i]) - 1);
            if (Mart.get(discount[i]) == 0) Mart.remove(discount[i]);
                
            // 뒤에꺼 추가
            Mart.put(discount[i+10], Mart.getOrDefault(discount[i+10], 0)+1);
            // 비교
            if (JH.equals(Mart)) count++;
        }
                return count;
        
    }
                }