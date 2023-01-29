package Greedy.baek1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int endTime = 0;
        int[][] conferences = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] t = br.readLine().split(" ");
            conferences[i][0] = Integer.parseInt(t[0]);
            conferences[i][1] = Integer.parseInt(t[1]);
        }
        Arrays.sort(conferences, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < N; i++) {
            if(conferences[i][0] >= endTime){
                count++;
                endTime = conferences[i][1];
            }
        }

        System.out.println(count);

    }
}
