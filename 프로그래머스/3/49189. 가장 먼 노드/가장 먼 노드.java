import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 인접 리스트 생성
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] vertex : edge) {
            adjList.get(vertex[0]).add(vertex[1]);
            adjList.get(vertex[1]).add(vertex[0]);
        }
        
        // 거리 배열 생성 및 -1로 초기화
        ArrayList<Integer> distance = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            distance.add(-1);
        }
        
        distance.set(1, 0); // 시작점은 0으로 초기화
        
        // 인접 리스트 BFS로 순회
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // 시작점
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < adjList.get(node).size(); i++) {
                int next = adjList.get(node).get(i);
                if (distance.get(next) == -1) {
                    q.offer(next);
                    distance.set(next, distance.get(node) + 1);
                }
            }
        }
        
        // distance 배열에서 max 구하기
        int max = distance.get(0);
        for (int i = 1; i <= n; i++) {
            if (distance.get(i) > max) {
                max = distance.get(i);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (max == distance.get(i)) {
                answer++;
            }
        }
        
        return answer;
    }
}