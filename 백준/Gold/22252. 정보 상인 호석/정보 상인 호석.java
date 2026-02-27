import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        Long answer = 0L;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            int query = Integer.parseInt(st.nextToken());

            if (query == 1) {
                // 정보를 얻는 정보 고릴라의 이름, 정보 가치의 갯수(k), k개의 정보 가치
                String infoKey = st.nextToken();
                int k = Integer.parseInt(st.nextToken());
                if (map.containsKey(infoKey)) { // 이전에 등장한 고릴라인 경우
                    while (k-- > 0) {
                        int value = Integer.parseInt(st.nextToken());
                        map.get(infoKey).add(value);
                    }
                } else { // 아닌 경우
                    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 큰 수가 먼저 나오도록
                    while (k-- > 0) {
                        int value = Integer.parseInt(st.nextToken());
                        pq.add(value);
                    }
                    map.put(infoKey, pq);
                }

            } else {
                // 호석이가 거래하려는 정보 고릴라의 이름, 구매하려는 정보의 갯수(b) - 가장 비싼 순
                // b개 이하면 모든 정보 구매
                String infoKey = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> pq = map.get(infoKey);
                while (pq != null && !pq.isEmpty() && b-- > 0) {
                    answer += pq.poll();
                }
            }
        }
        // 모든 쿼리가 종료되었을 때에 호석이가 얻게 되는 정보 가치의 총합 출력
        System.out.println(answer);
    }
}
