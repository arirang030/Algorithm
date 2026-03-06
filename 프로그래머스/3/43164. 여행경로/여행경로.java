import java.util.*;

class Solution {
    
    public List<String> solution(String[][] tickets) {
        
        List<String> path = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        path.add("ICN");
        dfs(tickets, path, visited, "ICN", 0);
        
        return path;
    }
    
    boolean dfs(String[][] tickets, List<String> path, boolean[] visited, String current, int cnt) {
        
        // 종료 조건
        if (cnt == tickets.length) return true;
        
        for (int i = 0; i < tickets.length; i++) {
            
            // 사용할 수 있는 티켓인지 검사
            if (!visited[i] && tickets[i][0].equals(current)) {
                
                // 티켓 사용
                visited[i] = true;
                path.add(tickets[i][1]);
                
                // 다음 공항 DFS
                if (dfs(tickets, path, visited, tickets[i][1], cnt + 1)) {
                    return true;
                }
                
                // 실패 시 백트래킹
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}