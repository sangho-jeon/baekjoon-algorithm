package Greedy.problem2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int five = N / 5;
        for (int i = five; i >= 0; i--) {
            if((N - i * 5) % 3 == 0){
                int result = i + (N - i * 5) / 3;
                System.out.println(result);
                return;
            }
        }
        System.out.println(-1);
    }
}
