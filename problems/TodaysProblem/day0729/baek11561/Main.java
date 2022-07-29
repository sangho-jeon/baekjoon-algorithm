package TodaysProblem.day0729.baek11561;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        long[] test = new long[testCase];
        double answer  = 0d;
        for (int i = 0; i < testCase; i++) {
            test[i] = Long.parseLong(sc.nextLine());
        }
        for (int i = 0; i < testCase; i++) {
            long k = test[i];
            double n = (Math.sqrt(1+(8*k)) - 1 )/ 2;
            int ans = (int) Math.floor(n);
            System.out.println(ans);

        }

    }
}
