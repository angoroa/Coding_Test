import java.util.*;

class Solution {
        int answer = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if (!visited[i]){
                dfs(i, visited, computers);
                answer++;
            }
        }
        return answer;
    }
    void dfs(int node, boolean[] visited, int[][] computers){
        visited[node] = true;
        for (int j=0; j< computers.length; j++){
            if(computers[node][j] == 1 && !visited[j]){
                dfs(j, visited, computers);
            } 
        }
    }
}