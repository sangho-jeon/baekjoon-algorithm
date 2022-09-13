package Toss.baek14675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] point = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            String[] tmp = sc.nextLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            point[a]++;
            point[b]++;
        }

        int c = Integer.parseInt(sc.nextLine());
        int[] t = new int[c];
        int[] p = new int[c];
        for (int i = 0; i < c; i++) {
            String[] tmp = sc.nextLine().split(" ");
            t[i] = Integer.parseInt(tmp[0]);
            p[i] = Integer.parseInt(tmp[1]);
        }
        for (int i = 0; i < c; i++) {
            if (t[i] == 2 ) {
                System.out.println("yes");
            } else  {
                if(point[p[i]]>1)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        }

    }
}
