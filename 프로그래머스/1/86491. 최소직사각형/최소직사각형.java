import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxW = 0;
        int maxH = 0;
        
        for (int[] card : sizes) {
            int big = Math.max(card[0], card[1]);
            int small = Math.min(card[0], card[1]);
            
            maxW = Math.max(maxW, big);
            maxH = Math.max(maxH, small);
        }
        
        return maxW * maxH;
    }
}