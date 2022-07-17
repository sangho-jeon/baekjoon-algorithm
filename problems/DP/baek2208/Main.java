package DP.baek2208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int[] jems = new int[N];
        int[] prefix = new int[N+1];
        for (int i = 0; i < N; i++) {
            jems[i] = Integer.parseInt(br.readLine());
            prefix[i+1] = prefix[i] + jems[i];
        }

        for (int i = 0; i <= N; i++) {
            System.out.println(prefix[i]);
        }

    }
}
