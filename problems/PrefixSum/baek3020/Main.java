package PrefixSum.baek3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int H = Integer.parseInt(tmp[1]);

        int[] stacks = new int[H];
        int[] stacks2 = new int[H];
        for (int i = 0; i < N; i++) {
            int poll = Integer.parseInt(br.readLine());
            if ((i + 1) % 2 == 0) {

                stacks2[0]++;
                stacks2[poll]--;

            } else {
                stacks[0]++;
                stacks[poll]--;
            }
        }

        for (int i = 1; i < H; i++) {
            stacks[i] += stacks[i - 1];
            stacks2[i] += stacks2[i - 1];
        }
        for (int i = 0; i < H; i++) {
            stacks[i] += stacks2[H - i - 1];
        }

        Arrays.sort(stacks);
        int min = stacks[0];
        int count = 1;
        for (int i = 1; i < H; i++) {
            if (stacks[i] == min) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(min +" "+count);


    }
}
