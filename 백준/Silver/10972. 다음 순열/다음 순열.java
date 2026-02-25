import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Vector<Integer> vec = new Vector<>();

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < n; k++) {
            vec.add(Integer.parseInt(st.nextToken()));
        }

        // 1. 뒤에서 부터 오름차순이 깨지는 가장 큰 index 구하기
        int i = n - 2;
        while (i >= 0 && vec.get(i) > vec.get(i + 1)) {
            i--;
        }

        // 1-1. 다음 순열이 없는 경우
        if (i < 0) {
            System.out.println(-1);
            return;
        }

        // 2. 오름차순 구간에서 index보다 큰 문자 중 가장 작은 문자 구하기
        int j = n - 1;
        while (vec.get(i) > vec.get(j)) {
            j--;
        }

        // 3. 스왑
        swap(vec, i, j);

        // 4. 오름차순 구간 리버스
        reverse(vec, i + 1, vec.size() - 1);

        for (int num : vec) {
            System.out.printf("%d ", num);
        }
    }

    public static void swap(Vector<Integer> vec, int i, int j) {
        int temp = vec.get(i);
        vec.set(i, vec.get(j));
        vec.set(j, temp);
    }

    public static void reverse(Vector<Integer> vec, int i, int j) {
        while (i < j) {
            swap(vec, i, j);
            i++;
            j--;
        }
    }
}
