import java.util.*;
import java.lang.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        for (String pb : phone_book) {
            set.add(pb);
        }
        
        Iterator<String> it = set.iterator();
        while (answer && it.hasNext()) {
            String number = it.next();
            for (int i = 1; i < number.length(); i++) {
                if (set.contains(number.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}