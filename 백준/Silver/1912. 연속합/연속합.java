import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()) - 1;

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int thisMulti = first;
        int maxMulti = first;
        while (n-- > 0) {
            int input = Integer.parseInt(st.nextToken());
            thisMulti = Math.max(input, thisMulti + input);
            maxMulti = Math.max(maxMulti, thisMulti);
        }

        System.out.println(maxMulti);
    }
}
