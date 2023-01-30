package day0130.problem2162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tmp;
        ArrayList<Line> lines = new ArrayList<>();
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            tmp = br.readLine().split(" ");
            lines.add(new Line(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]), i, i));
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(lines.get(i).isCrossed(lines.get(j))){
                    System.out.println("true");
                    union(i, j);
                }
                else{
                    System.out.println("false");
                }
            }
        }

        System.out.println(Arrays.toString(parent));

        System.out.println(lines);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        else
            return parent[x] = find(parent[x]);
    }

    static class Line {
        int x1, x2, y1, y2;
        int parent;
        int myNo;

        public Line(int x1, int y1, int x2, int y2, int parent, int myNo) {
            if(x1 > x2){
                this.x1 = x2;
                this.x2 = x1;
            }
            else{
                this.x1 = x1;
                this.x2 = x2;
            }
            if(y1 > y2){
                this.y1 = y2;
                this.y2 = y1;
            }
            else{
                this.y1 = y1;
                this.y2 = y2;
            }
            this.parent = parent;
            this.myNo = myNo;
        }

        public boolean isCrossed(Line target) {
            if (((x1 - x2) * (target.y1 - target.y2)) - ((y1 - y2) * (target.x1 - target.x2)) == 0) {
                return false;
            }
            double x, y;
            x = (double) ((x1 * y2 - y1 * x2) * (target.x1 - target.x2) - (x1 - x2) * (target.x1 * target.y2 - target.y1 * target.x2)) / (double) ((x1 - x2) * (target.y1 - target.y2) - (y1 - y2) * (target.x1 - target.x2));
            y = (double) ((x1 * y2 - y1 * x2) * (target.y1 - target.y2) - (y1 - y2) * (target.x1 * target.y2 - target.y1 * target.x2)) / (double) ((x1 - x2) * (target.y1 - target.y2) - (y1 - y2) * (target.x1 - target.x2));
            System.out.println(x + " " + y);
            if(x >= x1 && x <= x2 && target.x1 <= x && target.x2 >= x && y >= y1 && y <= y2 && target.y1 <= y && target.y2 >= y){
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "x1=" + x1 +
                    ", x2=" + x2 +
                    ", y1=" + y1 +
                    ", y2=" + y2 +
                    ", parent=" + parent +
                    ", myNo=" + myNo +
                    '}';
        }
    }
}
