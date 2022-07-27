package TodaysProblem.day0727.baek11441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] numbers = new int[N + 1];
        for (int i = 0; i < N; i++) {
            numbers[i+1] = numbers[i] + Integer.parseInt(tmp[i]);
        }

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] t = br.readLine().split(" ");
            int start = Integer.parseInt(t[0]);
            int end = Integer.parseInt(t[1]);
            answer.add(numbers[end] - numbers[start - 1]);
        }

        for (Integer ans:
             answer) {
            System.out.println(ans);
        }

    }
}
