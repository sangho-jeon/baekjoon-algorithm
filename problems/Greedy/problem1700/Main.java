package Greedy.problem1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        String[] tmp = br.readLine().split(" ");
        int hole = Integer.parseInt(t[0]);
        int N = Integer.parseInt(t[1]);
        int[] holes = new int[hole];
        int[] use = new int[N];
        for (int i = 0; i < N; i++) {
            use[i] = Integer.parseInt(tmp[i]);
        }
        int count = 0;

        for (int i = 0; i < N; i++) {
            int machine = use[i];
            if (!Arrays.stream(holes).boxed().collect(Collectors.toSet()).contains(machine)) {
                boolean flag = true;
                int[] p = Arrays.copyOfRange(use, i + 1, i + 1 + hole);
                for (int j = 0; j < hole; j++) {
                    if (!Arrays.stream(p).boxed().collect(Collectors.toSet()).contains(holes[j])) {
                        holes[j] = machine;
                        if (holes[j] != 0) {
                            count++;
                        }
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    holes[holes.length - 1] = machine;
                    count++;
                }
            }
            System.out.println(Arrays.toString(holes));
        }
        System.out.println(count);

    }
}
