package TodaysProblem.day0731.baek11726;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] blocks = new long[N];

        if (N == 2 || N == 1) {
            System.out.println(N);
            return;
        } else {
            blocks[0] = 1;
            blocks[1] = 2;
            for (int i = 2; i < N; i++) {
                blocks[i] = (blocks[i-1] + blocks[i-2]) % 10007;
            }
            System.out.println(blocks[N-1] % 10007);
        }
    }
}
