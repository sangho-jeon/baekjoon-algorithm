package Greedy.problem110000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] schedule = new long[N][2];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            schedule[i][0] = Long.parseLong(tmp[0]);
            schedule[i][1] = Long.parseLong(tmp[1]);
        }
        Arrays.sort(schedule, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] == o2[0])
                    return (int) (o1[1] - o2[1]);
                return (int) (o1[0] - o2[0]);
            }
        });



        PriorityQueue<Long> classes = new PriorityQueue<>();
        classes.offer(schedule[0][1]);

        for (int i = 1; i < N; i++) {
            if (classes.peek() <= schedule[i][0]) {
                classes.poll();
                classes.offer(schedule[i][1]);
                continue;
            }
            classes.add(schedule[i][1]);
        }
        System.out.println(classes.size());
    }
}
