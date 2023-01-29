package Greedy.problem11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(people);
        int[] suFix = new int[N];
        suFix[0] = people[0];
        for (int i = 1; i < N; i++) {
            suFix[i] = suFix[i-1] + people[i];
        }
        System.out.println(Arrays.stream(suFix).sum());
    }
}
