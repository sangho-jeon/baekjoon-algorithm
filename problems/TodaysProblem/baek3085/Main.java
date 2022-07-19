package TodaysProblem.baek3085;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
// start time - 5:27
public class Main {
    static int answer = 0;
    static String[][] board;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        board = new String[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().split("");
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N; j++) {
                String[][] tmp = new String[N][N];
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < N; l++) {
                        tmp[k][l] = board[k][l];
                    }
                }
                String a = board[i][j];
                String b = board[i+1][j];
                tmp[i][j] = b;
                tmp[i+1][j] = a;
                Check(tmp);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                String[][] tmp = new String[N][N];
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < N; l++) {
                        tmp[k][l] = board[k][l];
                    }
                }
                String a = board[i][j];
                String b = board[i][j+1];
                tmp[i][j] = b;
                tmp[i][j+1] = a;

                Check(tmp);
            }
        }
        System.out.println(answer+1);
    }

    public static void Check(String[][] map){
        int result = 0;
        for (int i = 0; i < N; i++) {
            String[] line = map[i];
            String start = line[0];
            int longest = 0;
            for (int j = 0; j < line.length; j++) {

                if(Objects.equals(line[j], start)){
                    longest++;
                }
                else{
                    result = Math.max(longest, result);
                    start = line[j];
                    longest = 1;
                }
            }

        }


        for (int i = 0; i < N; i++) {
            String[] line = new String[N];
            for (int j = 0; j < N; j++) {
                line[j] = map[j][i];
            }
            String start = line[0];
            int longest = 0;
            for (int j = 0; j < line.length; j++) {
                if(Objects.equals(line[j], start)){
                    longest++;
                }
                else{
                    result = Math.max(longest, result);
                    start = line[j];
                    longest = 1;
                }
            }
        }
        answer = Math.max(result, answer);
    }


}
