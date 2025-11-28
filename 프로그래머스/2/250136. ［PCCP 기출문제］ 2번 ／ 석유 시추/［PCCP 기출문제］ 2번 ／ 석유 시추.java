import java.util.*;

class Solution {
    
    // 아래, 오른쪽으로 이동
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        // 석유 덩어리에 고유 아이디 부여(2 이상)
        int id = 2;
        // key: 고유 아이디, value: 석유 영역 크기
        Map<Integer, Integer> oilSpot = new HashMap<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    land[i][j] = id;
                    int size = drilling(land, id, i, j);
                    oilSpot.put(id, size);
                    id++;
                }
            }
        }
        int answer = 0;
        for (int col = 0; col < land[0].length; col++) {
            int sum = 0;
            // 중복 방지를 위해 각 열에 있는 석유 덩어리의 고유 번호 구하기
            Set<Integer> oilSet = new HashSet<>();
            for (int row = 0; row < land.length; row++) {
                if (land[row][col] > 1) {
                    oilSet.add(land[row][col]);
                }
            }
            // set을 순회하며 고유 번호로부터 영역 크기 값을 가져와 합하기
            for (int oilId : oilSet) {
                sum += oilSpot.get(oilId);
            }
            // 각 열의 최종 합이 최댓값보다 크다면
            if (answer < sum) answer = sum;
        }
        return answer;
    }
    
    public int drilling(int[][] land, int id, int x, int y) {
        int cnt = 1;
        
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 범위 체크
            if (nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length) 
                continue;
            
            // 방문 안 했고, 이동 가능하면
            if (land[nx][ny] == 1) {
                land[nx][ny] = id;
                cnt += drilling(land, id, nx, ny);
            }
        }
        return cnt;
    }
}