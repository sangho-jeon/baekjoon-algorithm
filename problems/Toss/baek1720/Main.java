package Toss.baek1720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long result = 0;
        for (int i = 0; i <= N / 2; i++) {
            int two = i;
            int one = N - 2 * i;
            result +=  Comb(two, one) * (long) Math.pow(2, i);
//            System.out.println("first  " + result);
            if (!((two + one) % 2 == 0 && (two % 2 == 1 && one % 2 == 1))) {
                result += Comb(Math.floorDiv(two, 2), Math.floorDiv(one, 2)) * (long) Math.pow(2, Math.ceil((double) two/2));
//                System.out.println("second " + result);
            }
        }
        System.out.println(result/2);
    }

    public static long Comb(int two, int one) {
        int N = two + one;
        long result = 1;
        long div = 1;
        for (int i = 0; i < two; i++) {
            result *= (N - i);
        }
        for (int i = 1; i <= two; i++) {
            div *= i;
        }
        return result/div;
    }
}
