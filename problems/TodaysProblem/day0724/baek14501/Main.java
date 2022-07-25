package TodaysProblem.day0724.baek14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] day = new int[N];
        int[] profit = new int[N];
        int[] result = new int[N+1];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            day[i] = Integer.parseInt(tmp[0]);
            profit[i] = Integer.parseInt(tmp[1]);
        }

        for (int i = 0; i < N; i++) {
            int d = day[i];
            if (d + i <= N) {
                for (int j = d + i; j <= N; j++) {
                    result[j] = Math.max(result[j], profit[i] + result[i]);
                }
            }
        }

        System.out.println(result[N]);
    }
}
