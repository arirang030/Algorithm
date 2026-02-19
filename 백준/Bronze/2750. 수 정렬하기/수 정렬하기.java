import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.sort;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        sort(array);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
