import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        // 1. 도착 시간 순 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        // 2. 소요시간 짧은 순으로 꺼내는 pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        int time = 0;   // 현재 시간
        int total = 0;  // 총 반환시간 합
        int idx = 0;    // jobs 배열에서 몇 번째까지 확인했는지
        while(idx < jobs.length || !pq.isEmpty()){
            // 1. 현재 시간까지 도착한 작업들 PQ에 넣기
            while (idx < jobs.length && jobs[idx][0]<=time){
                pq.offer(jobs[idx++]);
            }
            // 2. PQ에서 꺼내서 처리
            if (!pq.isEmpty()){
                int dt[] = pq.poll();
                time += dt[1];
                int retime = time - dt[0];
                total += retime;
            } else{
                time = jobs[idx][0];
            }

        }
        return total / jobs.length;
    }
}