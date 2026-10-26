class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 0;
        // 홀수 or 짝수
        while(a!=b){
            if(a % 2 ==1){
                a = (a + 1)/2;
            }
            else{
                a = a / 2;
            }
            if(b % 2 == 1){
                b = (b + 1) /2;
            }
            else{
                b = b /2;
            }
            count++;
        }

        return count;
    }
}