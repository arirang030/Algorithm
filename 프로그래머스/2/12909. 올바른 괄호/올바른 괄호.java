import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c == '(') {
                stack.push(c);
            } 
            else {
                char p = stack.pop();
                if (p != '(') {
                    answer = false;
                    break;
                }
            }
        }

        return stack.isEmpty() ? answer : false;
    }
}