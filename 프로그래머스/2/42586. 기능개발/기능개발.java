import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int maxDay = ((100 - progresses[0]) + speeds[0] - 1) / speeds[0];
        int cnt = 1;
        for (int i = 1; i < progresses.length; i++) {
            // 각 작업의 걸리는 일 수 계산
            int day = ((100 - progresses[i]) + speeds[i] - 1) / speeds[i];
            if (day > maxDay) { // 새로운 배포
                maxDay = day;
                answer.add(cnt);
                cnt = 1;
            } else { // 같은 날 배포
                cnt++;
            }
        }
        answer.add(cnt);
        return answer;
    }
}