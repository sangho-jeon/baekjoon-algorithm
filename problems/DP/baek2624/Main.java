package DP.baek2624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> coins = new HashMap<>();
        for (int i = 0; i < K; i++) {
            String[] tmp = br.readLine().split(" ");
            int A = Integer.parseInt(tmp[0]);
            int B = Integer.parseInt(tmp[1]);
            coins.put(A, B);
        }
        System.out.println(coins);
    }
}
