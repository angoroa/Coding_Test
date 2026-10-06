import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        // (ID, 이름)
        for(int i=0; i<record.length; i++){
            String parts[] = record[i].split(" ");
            if (parts[0].equals("Enter")){
                map.put(parts[1], parts[2]);
            }

            else if(parts[0].equals("Change")){
                map.put(parts[1], parts[2]);
            }
            // parts[0], parts[1], parts[2]
        }
        for (int i=0; i<record.length; i++){
            String parts[] = record[i].split(" ");
            if(parts[0].equals("Enter")){
                result.add(map.get(parts[1])+ "님이 들어왔습니다.");
            }else if(parts[0].equals("Leave")){
                result.add(map.get(parts[1])+ "님이 나갔습니다.");
            }
        }
        // Enter, Leave, Change 개수를 우리가 알 수 없으므로
        // ArrayList로 넣는게 낫다.
        return result.toArray(new String[0]);
    }
}