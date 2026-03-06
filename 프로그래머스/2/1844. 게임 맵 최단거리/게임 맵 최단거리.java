import java.util.*;

class Solution {
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        
        while (!q.isEmpty()) {
            Point point = q.poll();
            
            int cx = point.getX();
            int cy = point.getY();
            
            if (cx == n && cy == m) {
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || ny < 0 || nx > n || ny > m) continue;
                if (maps[nx][ny] != 1) continue;
                
                maps[nx][ny] = maps[cx][cy] + 1;
                q.offer(new Point(nx, ny));
            }
        }
        return maps[n][m] == 1 ? -1 : maps[n][m];
    }
    
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return x;
        }
        int getY() {
            return y;
        }
    }
}