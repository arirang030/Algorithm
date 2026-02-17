import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = n;
        while (n-- > 0) {
            String s = br.readLine();

            Set<Character> set = new HashSet<>();
            Vector<Character> vec = new Vector<>();

            set.add(s.charAt(0));
            vec.add(s.charAt(0));

            for (int i = 1; i < s.length(); i++) {
                // 연속적이지 않을 경우
                if (s.charAt(i - 1) != s.charAt(i)) {
                    vec.add(s.charAt(i));
                    set.add(s.charAt(i));

                    if (vec.size() != set.size()) {
                        result--;
                        break;
                    }
                }
            }
        }
        System.out.println(result);

        br.close();
    }
}
