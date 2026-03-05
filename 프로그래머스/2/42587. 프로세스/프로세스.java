import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<Integer> priority = new LinkedList<>();
        Queue<Integer> order = new LinkedList<>();
        List<Integer> pOfList = new ArrayList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            priority.add(priorities[i]);
            order.add(i);
            pOfList.add(priorities[i]);
        }
        
        Collections.sort(pOfList, Comparator.reverseOrder());

        while (!priority.isEmpty()) {
            int p = priority.poll();
            int o = order.poll();
            if (p < pOfList.get(answer - 1)) { // 최대 우선순위가 아닌 경우 맨 뒤로 넘김
                priority.add(p);
                order.add(o);
            }
            else {
                if (o == location) { // 최대 우선순위고 찾고자 하는 프로세스라면 멈춤
                    break;
                } else { // 아니라면 그 다음 최대 우선순위 찾기
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}