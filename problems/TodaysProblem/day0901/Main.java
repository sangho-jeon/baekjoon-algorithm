package TodaysProblem.day0901;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] grid = {"SL","LR"};
        System.out.println(Arrays.toString(solution(grid)));
    }

    static int N, M;
    static boolean[][][] visited;
    static char[][] board;

    public static int[] solution(String[] grid) {

        N = grid[0].length();
        M = grid.length;
        board = new char[N][M];
        visited = new boolean[N][M][4];
        for (int i = 0; i < M; i++) {
            char[] tmp = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                board[j][i] = tmp[j];
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        answer.add(go(i, j, k));
                    }
                }
            }
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        Arrays.sort(result);
        return result;
    } // dir 0 1 2 3 -> 아래 왼 위 오른 반시계

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int go(int x, int y, int dir) {
        int count = 0;
        while (!visited[x][y][dir]) {
            visited[x][y][dir] = true;
            count++;
            switch (board[x][y]) {
                case 'L':
                    dir = (dir + 3) % 4;
                    break;
                case 'R':
                    dir = (dir + 1) % 4;
                    break;
            }
            x = (x + dx[dir] + N) % N;
            y = (y + dy[dir] + M) % M;
        }
        return count;
    }
}


