import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) - 1;

        double first = Double.parseDouble(br.readLine());
        double thisMulti = first;
        double maxMulti = first;
        while (n-- > 0) {
            double input = Double.parseDouble(br.readLine());
            thisMulti = Math.max(input, thisMulti * input);
            maxMulti = Math.max(maxMulti, thisMulti);
        }

        System.out.printf("%.3f\n", maxMulti);
    }
}
