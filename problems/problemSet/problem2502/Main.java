package problemSet.problem2502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        int a = 1;
        int aTmp = 1;
        int aTmp2 = 1;
        int b = 1;
        int bTmp = 1;
        int bTmp2 = 1;

        if (N == 1) {
            a = 1;
            b = 0;
        } else if (N == 2) {
            a = 0;
            b = 1;
        } else {
            for (int i = 0; i < N - 4; i++) {
                int t = 0;
                a = aTmp + aTmp2;

                aTmp = a;
                t = aTmp;
                aTmp = aTmp2;
                aTmp2 = t;
            }
            for (int i = 0; i < N - 3; i++) {
                int t = 0;
                b = bTmp + bTmp2;

                bTmp = b;
                t = bTmp;
                bTmp = bTmp2;
                bTmp2 = t;
            }
        }
        int first = 1;
        int second = M-1;
        System.out.println(a + " " +b);
        while (true) {
            if (first % a == 0 && second % b == 0) {
                System.out.println(first/a);
                System.out.println(second/b);
                return;
            } else {
                first++;
                second--;
            }
        }

//        System.out.println(a + " " + b);
    }
}
