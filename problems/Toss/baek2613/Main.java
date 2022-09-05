package Toss.baek2613;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        String[] t = sc.nextLine().split(" ");
        int[] balls = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            balls[i] = Integer.parseInt(t[i]);
        }
    }
}
