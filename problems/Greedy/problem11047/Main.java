package Greedy.problem11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);
        int[] coins = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N - 1; i >= 0 ; i--) {
            if(K == 0){
                break;
            }
            if(coins[i] <= K){
                count += K / coins[i];
                K = K % coins[i];
            }
        }
        System.out.println(count);
    }
}
