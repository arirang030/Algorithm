import java.util.*;

class Solution {
    public Vector<Integer> solution(int[] answers) {
        Vector<Integer> vec = new Vector<>();
        
        int[] supoza1 = {1, 2, 3, 4, 5};
        int[] supoza2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoza3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cnt = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (supoza1[i % 5] == answers[i]) cnt[0]++;
            if (supoza2[i % 8] == answers[i]) cnt[1]++;
            if (supoza3[i % 10] == answers[i]) cnt[2]++;
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == max) {
                vec.add(i + 1);
            }
        }
        
        return vec;
    }
}