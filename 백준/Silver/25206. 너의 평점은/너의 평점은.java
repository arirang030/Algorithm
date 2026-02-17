import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 학점-과목평점
        HashMap<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = 20;
        double totalCredit = 0; // 총 학점
        double majorGpa = 0; // 전공평점
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            double credit = Double.parseDouble(st.nextToken()); // 학점
            String level = st.nextToken(); // 등급
            if (level.equals("P"))
                continue;

            double gpa = map.get(level); // 과목평점
            totalCredit += credit;
            majorGpa += credit * gpa;
        }
        double answer = majorGpa / totalCredit;
        System.out.println(answer);
    }
}