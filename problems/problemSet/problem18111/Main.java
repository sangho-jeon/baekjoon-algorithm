package problemSet.problem18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int B = Integer.parseInt(tmp[2]);
        int[][] map = new int[N][M];
        long total = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
                total += map[i][j];
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        total += B;
        int K = (int) (total / (N * M));
        int height = Math.min(max, K);
        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;
        for (int i = height; i >= min; i--) {
            int tTmp = 0;
            int hTmp = i;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int line = map[j][k];
                    if (i > line) {
                        tTmp += (i - line);
                    } else {
                        tTmp += 2 * (line - i);
                    }
                }
            }
            if(tTmp == resultHeight && resultHeight < hTmp){
                resultHeight = hTmp;
            }
            else if(tTmp < resultTime){
                resultTime = tTmp;
                resultHeight = hTmp;
            }
        }


        System.out.println(resultTime +" " +resultHeight);
    }
}
