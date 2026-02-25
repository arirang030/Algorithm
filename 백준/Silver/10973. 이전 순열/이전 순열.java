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

        // 1. 뒤에서 부터 내림차순이 깨지는 가장 큰 index 구하기
        int i = n - 2;
        while (i >= 0 && vec.get(i) < vec.get(i + 1)) {
            i--;
        }

        // 1-1. 이전 순열이 없는 경우
        if (i < 0) {
            System.out.println(-1);
            return;
        }

        // 2. 내림차순 구간에서 index보다 작은 수 중 가장 큰 수의 index 구하기
        int j = n - 1;
        while (j > i && vec.get(i) < vec.get(j)) {
            j--;
        }

        // 3. 스왑
        swap(vec, i, j);

        // 3. 리버스
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
