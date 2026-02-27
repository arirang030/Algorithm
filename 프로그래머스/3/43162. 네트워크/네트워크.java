import java.util.*;

class Solution {
    
    int answer = 0;
    Vector<Integer> visited;
    
    public void bfs(int[][] computers, int v) {
        if (visited.get(v) == 1)
            return;
        visited.set(v, 1);
        for (int i = 0; i < computers[v].length; i++) {
            if (computers[v][i] == 1) {
                bfs(computers, i);
            }
        }
        return;
    }
    
    public int solution(int n, int[][] computers) {
        visited = new Vector<>(n);
        for (int i = 0; i < n; i++) {
            visited.add(0);
        }
        
        for (int i = 0; i < n; i++) {
            if (visited.get(i) == 1)
                continue;
            bfs(computers, i);
            answer++;
        }
        
        return answer;
    }
}