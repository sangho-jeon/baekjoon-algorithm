package TodaysProblem.day0727.baek1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    static class Node{
        public int start;
        public int end;
        public int weight;

        public Node(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static int[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int V = Integer.parseInt(tmp[0]);
        points = new int[V+1];
        int E = Integer.parseInt(tmp[1]);
        ArrayList<Node> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            String[] t = br.readLine().split(" ");
            edges.add(new Node(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2])));
        }
        for (int i = 0; i <= V; i++) {
            points[i] = i;
        }
        edges.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        int answer = 0;
        for (Node e:
             edges) {
            if(find(e.start) != find(e.end)){
                union(e.start, e.end);
                answer += e.weight;
            }
        }
        System.out.println(answer);
     }

     public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            points[b] = a;
        }
     }
     public static int find(int a){
        if(points[a] == a){
            return a;
        }
        else{
            return points[a] = find(points[a]);
        }
     }

}
