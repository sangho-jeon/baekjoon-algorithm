package TodaysProblem.day0725.baek1456;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        long start = Long.parseLong(tmp[0]);
        long end = Long.parseLong(tmp[1]);
        int startRoot = (int)Math.sqrt(start);
        int endRoot = (int)Math.sqrt(end);
        long[] numbers = new long[(int)(endRoot-startRoot+1)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = startRoot+i;
        }


        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0)
                continue;
            for (int j = (int)(2*numbers[i]); j <= endRoot; j+=i) {
                numbers[j]= 0;
            }
        }
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] != 0){
                long t = (long)Math.pow(i, 2);
                int p = 2;
                boolean ended = false;
                while (!ended) {
                    if( start < t && t < end){
                        result++;
                        p++;
                        t = (int)Math.pow(i, p);
                    }
                    else if(t > end){
                        ended = true;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
