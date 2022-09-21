package devCourse.ㅜㅕㅡ3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 9;
        int[][] mine = {{1, 2}, {2, 6}, {3, 4}, {3, 8}, {4, 9}, {5, 4}, {5, 8}, {6, 7}, {7, 2}, {9, 1}};
        int[] P = {8, 5};
        System.out.println(solution.solution(N, mine, P));
    }
}

class Solution {
    static int[][] map;
    static int n;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public int solution(int N, int[][] mine, int[] P) {
        int answer = 0;
        map = new int[N + 2][N + 2];
        visited = new boolean[N+2][N+2];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if(i == 0 || j == 0 || i == N+1 || j == N+1)
                    visited[i][j] = true;
            }
        }
        n = N;
        for (int i = 0; i < mine.length; i++) {
            int x = mine[i][0];
            int y = mine[i][1];
            map[x][y] = -1;
        }
        Fill();
        System.out.println(Arrays.deepToString(map));
        return BFS(P[0], P[1]);
    }

    public void Fill() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 0) {
                    int count = 0;
                    for (int k = 0; k < dx.length; k++) {
                        int px = i + dx[k];
                        int py = j + dy[k];
                        if(map[px][py] == -1)
                            count++;
                    }
                    map[i][j] = count;
                }
            }
        }
    }
    public int BFS(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(x, y);
        queue.offer(node);
        visited[x][y] = true;
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            Node n = queue.poll();
            int cx = n.x;
            int cy = n.y;
            for (int i = 0; i < 8; i++) {
                int tx = cx + dx[i];
                int ty = cy + dy[i];
                if(!visited[tx][ty] && map[tx][ty] == 0){
                    visited[tx][ty] = true;
                    Node next = new Node(tx,ty);
                    queue.offer(next);
                }
                else if(!visited[tx][ty]){
                    visited[tx][ty] = true;
                    count++;
                }
            }
        }


        return count;
    }
}
class Node{
    public int x;
    public int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
