class Solution {
    public int toSec(String s){
        String[] parts = s.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    public String toMMSS(int sec){
        return String.format("%02d:%02d", sec/60, sec%60);
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = toSec(video_len);
        int cur = toSec(pos);
        int os = toSec(op_start);
        int oe = toSec(op_end);
        
        if (cur >= os && cur <= oe) cur = oe;
        
        for (String c:commands){
            if (c.equals("prev")) {
              cur = Math.max(0, cur -10);
                
            } 
            else if (c.equals("next")) {
                // else {}
              cur = Math.min(len, cur+10);  
            }
            if (cur >= os && cur <= oe) cur = oe;
        }
        return toMMSS(cur);
    }
}