
class Solution {
    public int[] solution(int n, int m) {
        int[] answers = new int[2];
        for(int i=1; i<=Math.min(n,m); i++){
                if (n%i==0&&m%i==0) answers[0] = i;
            }
        answers[1] = n * m / answers[0];
        return answers;
    }
}