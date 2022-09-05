package Toss.baek14499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dx, dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int x = Integer.parseInt(tmp[2]);
        int y = Integer.parseInt(tmp[3]);
        int[] command = new int[Integer.parseInt(tmp[4])];
        map = new int[N][M];
        dx = new int[]{0, 0, -1, 1};
        dy = new int[]{1, -1, 0, 0};
        for (int i = 0; i < N; i++) {
            String[] t = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(t[j]);
            }
        }
        tmp = sc.nextLine().split(" ");
        for (int i = 0; i < command.length; i++) {
            command[i] = Integer.parseInt(tmp[i]);
        }

        Dice dice = new Dice();
        dice.x = x; dice.y = y;
        dice.copy();
        for (int i = 0; i < command.length; i++) {
            int comm = command[i];
            int tx = dice.x+dx[comm-1];
            int ty = dice.y+dy[comm-1];
            if( tx >= 0 && tx < N && ty >= 0 && ty < M){
                dice.roll(comm);
                dice.x = tx;
                dice.y = ty;
                dice.copy();
                dice.out();
            }
        }
    }

    public static class Dice {
        public int x;
        public int y;

        public int top = 0;
        public int bottom = 0;
        public int up = 0;
        public int left = 0;
        public int right = 0;
        public int down = 0;

        public void roll(int command) {
            int[] result;
            switch (command) {
                case 1:
                    result = swap(this.top, this.right, this.bottom, this.left);
                    this.top = result[0];
                    this.right = result[1];
                    this.bottom = result[2];
                    this.left = result[3];
                    break;
                case 2:
                    result = swap(this.top, this.left, this.bottom, this.right);
                    this.top = result[0];
                    this.left = result[1];
                    this.bottom = result[2];
                    this.right = result[3];
                    break;
                case 3:
                    result = swap(this.top, this.up, this.bottom, this.down);
                    this.top = result[0];
                    this.up = result[1];
                    this.bottom = result[2];
                    this.down = result[3];
                    break;
                case 4:
                    result = swap(this.top, this.down, this.bottom, this.up);
                    this.top = result[0];
                    this.down = result[1];
                    this.bottom = result[2];
                    this.up = result[3];
                    break;
            }
        }

        public void copy() {
            if(map[this.x][this.y] != 0){
                this.bottom = map[this.x][this.y];
                map[this.x][this.y] = 0;
            }
            else{
                map[this.x][this.y] = this.bottom;
            }
        }
        public void out(){
            System.out.println(this.top);
        }

        public int[] swap(int a, int b, int c, int d) {
            int[] answer = new int[4];
            answer[0] = d;
            answer[3] = c;
            answer[2] = b;
            answer[1] = a;
            return answer;
        }

    }
}
