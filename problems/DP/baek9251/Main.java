package DP.baek9251;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().split("");
        String[] second = sc.nextLine().split("");
        int[][] map = new int[first.length + 1][second.length + 1];
        int max = 0;
        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if(!Objects.equals(first[i-1], second[j-1])){
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
                else{
                    map[i][j] = map[i-1][j-1] + 1;
                }
                max = Math.max(map[i][j], max);
            }
        }
        System.out.println(max);

    }
}
