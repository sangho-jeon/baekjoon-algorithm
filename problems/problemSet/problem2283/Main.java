package problemSet.problem2283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] numbers;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int target = Integer.parseInt(tmp[1]);

        numbers = new int[1000001];
        int max = 0;
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().split(" ");
            numbers[Integer.parseInt(tmp[0])]++;
            numbers[Integer.parseInt(tmp[1])]--;
            max = Math.max(max, Integer.parseInt(tmp[1]));
        }

        for (int i = 1; i <= max; i++) {
            numbers[i] += numbers[i - 1];
        }
//        for (int i = 1; i <= max; i++) {
//            numbers[i] += numbers[i-1];
//        }


        for (int i = 0; i <= max; i++) {
            System.out.print(numbers[i] + ",");
        }
        int start = 0;
        int end = 0;
        int container = 0;

        DFS(start, end, container, target, max);

//        while (end <= max) {
//            System.out.println("container: " + container + " start: " + start + " end: " + end);
//            if (container < target) {
//                container += numbers[end];
//                end++;
//            } else if (container > target) {
//                container -= numbers[start];
//                start++;
//            } else {
//                System.out.println((start) + " " + end);
//                return;
//            }
//        }
        if (!flag) {
            System.out.println("0 0");
        }
    }

    static void DFS(int start, int end, int container, int target, int max) {
        System.out.println(max);
        if (end > max) {
            System.out.println("0 0");
            return;
        }
        else if (container < target) {
            container += numbers[end];
            end++;
            DFS(start, end, container, target, max);
        } else if (container > target) {
            container -= numbers[start];
            start++;
            DFS(start, end, container, target, max);
        } else {
            System.out.println(start + " " + end);
            flag = true;
            return;
        }
    }

}
