package BruteForceBackTracking.baek14888;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] operator_num;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] numbers = new int[N];
        int[] operator = new int[N - 1];
        int[] operation_count = new int[4];
        operator_num = new int[4];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operator_num[i] = sc.nextInt();
        }
        Comb(numbers, operator, operation_count, 0);
        System.out.println(max);
        System.out.println(min);

    }

    public static void Comb(int[] numbers, int[] operator, int[] operator_count, int depth) {
        if (depth == N - 1) {
            if (Arrays.equals(operator_count, operator_num)) {
                int result = Sum(numbers, operator);
                if (result > max) {
                    max = result;
                }
                if (result < min) {
                    min = result;
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (operator_num[i] > operator_count[i]) {
                    operator[depth] = i;
                    operator_count[i] += 1;
                    Comb(numbers, operator, operator_count, depth + 1);
                    operator_count[i] -= 1;
                }
            }
        }
    }

    public static int Sum(int[] numbers, int[] operators) {
        int result = numbers[0];
        for (int i = 1; i < N; i++) {
            int operator = operators[i - 1];
            switch (operator) {
                case 0:
                    result += numbers[i];
                    break;
                case 1:
                    result -= numbers[i];
                    break;
                case 2:
                    result = result * numbers[i];
                    break;
                case 3:
                    result = result / numbers[i];
            }
        }
        return result;
    }
}
