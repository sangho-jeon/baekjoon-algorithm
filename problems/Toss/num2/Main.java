package Toss.num2;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] levels = {1, 2, 4, 3, 5, 6, 7, 8, 9};
        int answer = 0;
        /////
        Integer[] t = new Integer[levels.length];
        for (int i = 0; i < levels.length; i++) {
            t[i] = levels[i];
        }
        Arrays.sort(t, Collections.reverseOrder());
        int num = levels.length/4 -1;
        answer = t[num];

        System.out.println(answer);







    }
}
