import java.io.*;
import java.util.*;

public class Main {

    static long A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long pow(long a, long b) {
        // 기저 조건
        if (b == 0) return 1;

        // 재귀로 절반 계산
        long half = pow(a, b / 2);

        // 짝수 / 홀수 분기
        if (b % 2 == 0) {
            return (half * half) % C;
        } else {
            return (half * half % C) * (a % C) % C;
        }
    }
}