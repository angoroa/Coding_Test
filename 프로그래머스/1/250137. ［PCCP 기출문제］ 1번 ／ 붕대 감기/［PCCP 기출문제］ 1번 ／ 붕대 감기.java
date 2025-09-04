class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int castTime = bandage[0];  // 시전 시간(연속 성공해야 하는 초)
        int healPerSec = bandage[1]; // 초당 회복량
        int bonusHeal = bandage[2];  // 추가 회복량

        int maxHealth = health;   // 최대 체력
        int curHp = health;       // 현재 체력
        int success = 0;          // 연속 시전 성공 시간(초)
        int prevTime = 0;         // 직전 공격 시간 (처음엔 0초로 가정)

        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];

            // 1) 직전 공격 이후 ~ 이번 공격 직전까지 회복 시뮬레이션
            int gap = attackTime - prevTime - 1; // 공격 시각은 제외(-1)
            for (int t = 0; t < gap; t++) {
                // 초당 회복
                curHp += healPerSec;
                if (curHp > maxHealth) curHp = maxHealth;

                // 연속 시전 시간 증가
                success++;

                // 시전 시간 도달 시 보너스 회복 후 연속시간 초기화
                if (success == castTime) {
                    curHp += bonusHeal;
                    if (curHp > maxHealth) curHp = maxHealth;
                    success = 0;
                }
            }

            // 2) 공격 시간: 피해 적용 & 붕대 끊김(연속시간 초기화)
            curHp -= damage;
            if (curHp <= 0) return -1;  // 사망

            success = 0;           // 공격 맞으면 시전 끊김
            prevTime = attackTime; // 직전 공격 시각 갱신
        }

        // 3) 모든 공격 후 생존했다면 현재 체력 반환
        return curHp;
    }
}
