package DP.baek2073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static class Pipe {
        public int d;
        public int p;

        public Pipe(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int distance = Integer.parseInt(t[0]);
        int P = Integer.parseInt(t[1]);
        ArrayList<Pipe> pipes = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            String[] tmp = br.readLine().split(" ");
            pipes.add(new Pipe(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        }

        int[] dp = new int[distance + 1];
        dp[0] = Integer.MAX_VALUE;

        for (Pipe p :
                pipes) {
            int l = p.d;
            int w = p.p;

            for (int i = distance; i >= l; i--) {

                dp[i] = Math.max(dp[i], Math.min(dp[i-l], w));

            }

        }
        System.out.println(dp[dp.length - 1]);
    }

}
