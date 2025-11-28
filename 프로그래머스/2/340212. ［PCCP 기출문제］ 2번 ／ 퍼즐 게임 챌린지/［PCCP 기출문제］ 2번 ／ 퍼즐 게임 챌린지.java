class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long base = 0L;
        for (int time : times) base += time;
        
        // left는 난이도의 최솟값, right는 난이도의 최댓값.
        int left = 1;
        int right = diffs[0];
        for (int diff : diffs) {
            if (right < diff) right = diff;
        }
        
        // 로직:
        // 제한 시간 내 불가능 -> left = mid + 1
        // 제한 시간 내 가능 -> right = mid
        int mid = left + (right - left) / 2;
        while (right != left) {
            long penalty = 0L;
            for (int i = 1; i < diffs.length; i++) {
                if (mid < diffs[i]) {
                    penalty += (times[i] + times[i - 1]) * (diffs[i] - mid);
                }
            }
            if (limit < base + penalty) left = mid + 1;
            else right = mid;
            mid = left + (right - left) / 2;
        }
        return mid;
    }
}