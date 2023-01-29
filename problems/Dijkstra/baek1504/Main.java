package Dijkstra.baek1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<ArrayList<Node>> Graph = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]); // node
        M = Integer.parseInt(tmp[1]); // edge
        int result1 = 0;
        int result2 = 0;
        int p, q;
        for (int i = 0; i <= N; i++) {
            Graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] t = br.readLine().split(" ");
            int start = Integer.parseInt(t[0]);
            int end = Integer.parseInt(t[1]);
            int weight = Integer.parseInt(t[2]);
            Graph.get(start).add(new Node(end, weight));
            Graph.get(end).add(new Node(start, weight));
        }
        tmp = br.readLine().split(" ");
        p = Integer.parseInt(tmp[0]);
        q = Integer.parseInt(tmp[1]);

        result1 += Dijksta(1, p);
        result1 += Dijksta(p, q);
        result1 += Dijksta(q, N);

        result2 += Dijksta(1, q);
        result2 += Dijksta(q, p);
        result2 += Dijksta(p, N);

        int result = (result1 >= 20000000 && result2 >= 20000000) ? -1 : Math.min(result1, result2);


        System.out.println(result);
    }

    public static int Dijksta(int start, int end) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, 200000000);
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node s = queue.poll();
            int current = s.end;
            if(!visited[current]){
                visited[current] = true;
                for (Node n:
                     Graph.get(current)) {
                    if(!visited[n.end]&&dist[n.end] > dist[current] + n.weight){
                        dist[n.end] = dist[current] + n.weight;
                        queue.add(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }
        return dist[end];
    }


    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
