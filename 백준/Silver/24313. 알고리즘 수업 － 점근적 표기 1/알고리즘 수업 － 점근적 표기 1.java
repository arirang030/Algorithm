import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        int flag = 1;

        // f(n)의 기울기가 더 큰 경우
        if (a1 > c)
            flag = 0;
        // 기울기가 같은 경우
        else if (a1 == c && a0 > 0)
            flag = 0;
        // f(n)의 기울기가 더 작지만 교차점이 n0보다 앞에 있는 경우
        else if (a1 < c && n0 < (a0 / (c - a1)))
            flag = 0;

        System.out.println(flag);
    }
}
