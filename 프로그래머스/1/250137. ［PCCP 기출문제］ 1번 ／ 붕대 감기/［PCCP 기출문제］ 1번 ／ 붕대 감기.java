class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int streak = 0;
        int stamina = health;
        int time = attacks[attacks.length - 1][0];
        int attack_cnt = 0;
        
        for (int i = 1; i <= time; i++) {
            // 체력이 0 이하인 경우
            if (stamina <= 0) {
                break;
            }
            // 공격당한 경우
            if (i == attacks[attack_cnt][0]) {
                stamina -= attacks[attack_cnt][1];
                attack_cnt += 1;
                streak = 0; // 연속 성공 초기화
                continue;
            }
            streak += 1;
            // 현재 체력이 최대 체력보다 크거나 같은 경우
            if (stamina >= health) {
                stamina = health;
                continue;
            }
            // 연속 붕대 감기에 성공한다면
            if (streak >= bandage[0]) {
                stamina = stamina + bandage[1] + bandage[2];
                streak = 0; // 연속 성공 초기화
            } else { // 그렇지 않다면
                stamina += bandage[1];
            }
        }
        
        if (stamina >= health) stamina = health;
        return stamina <= 0 ? -1 : stamina;
    }
}