import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) - 1;

        int answer = 666;

        while (n-- > 0) {
            answer++;
            if (!String.valueOf(answer).contains("666"))
                n++;
        }
        System.out.println(answer);
    }
}
