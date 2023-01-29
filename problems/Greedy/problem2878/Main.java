package Greedy.problem2878;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        Long M = Long.parseLong(tmp[0]);
        int N = Integer.parseInt(tmp[1]);
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(br.readLine());
        }
        long n = (sum - M) / N;
        long offset = (sum - M) % N;
        long NCount = N - offset;
        long result = 0;
        if (n != 0) {
            result += (long) (NCount * Math.pow(2, n));
        }
        result += (long) offset * Math.pow(2, n + 1);
        System.out.println(result % Math.pow(2, 64));
    }
}
