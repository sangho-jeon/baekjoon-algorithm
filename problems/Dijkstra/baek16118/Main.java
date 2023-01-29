package Dijkstra.baek16118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<ArrayList<Node>> Graph = new ArrayList<>(); // linked list for implement node graph. the index is the start node number;
    static int N, M; // about node and edges;
    static long[] foxDist;
    static long[][] wolfDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        for (int i = 0; i < N + 1; i++) {
            Graph.add(new ArrayList<>());
        }
        foxDist = new long[N + 1];
        wolfDist = new long[2][N + 1];
        for (int i = 0; i < M; i++) {
            String[] t = br.readLine().split(" ");
            int start = Integer.parseInt(t[0]);
            int end = Integer.parseInt(t[1]);
            int weight = Integer.parseInt(t[2]) * 2;
            Graph.get(start).add(new Node(end, weight));
            Graph.get(end).add(new Node(start, weight));
        }
        Dijkstra(1);
        WolfDijkstra(1);
//        System.out.println(Arrays.toString(foxDist));
//        System.out.println(Arrays.toString(wolfDist[0]));
//        System.out.println(Arrays.toString(wolfDist[1]));
        int count = 0;
        for (int i = 0; i < N+1; i++) {
            if(foxDist[i] < Math.min(wolfDist[0][i], wolfDist[1][i])) count++;
        }
        System.out.println(count);

    }

    public static void Dijkstra(int start) {
//        int[] dist = new int[N+1]; // this means distance from start to end;
        Arrays.fill(foxDist, Integer.MAX_VALUE); // Dijkstra must fill the initial value with max value. to apply "min" method;

        PriorityQueue<Node> pq = new PriorityQueue<>(); // priority queue for sorting the next nodes;

        pq.offer(new Node(start, 0)); // initializing the starting node with 0;
        foxDist[start] = 0; // initializing the distance of myself;
        while (!pq.isEmpty()) {
            Node c = pq.poll();
            int current = c.next; // this is current node;

            if (foxDist[current] < c.weight)
                continue;

            for (Node next :
                    Graph.get(current)) { // getting linked node from current node. its a list.
                if (foxDist[next.next] > foxDist[current] + next.weight) { // 방문하지 않았고, 다음번 갈 노드의 거리가 지금 온 노드를 거쳐서 가는 것 보다 멀다면.
                    foxDist[next.next] = foxDist[current] + next.weight;
                    pq.offer(new Node(next.next, foxDist[next.next])); // 이거의 의미는 잘 모르겠는데;; 새로운 노드로 업데이트 하는 듯;
                }
            }

        }
    }

    public static void WolfDijkstra(int start) {
//        int[] dist = new int[N+1]; // this means distance from start to end;
        Arrays.fill(wolfDist[0], Integer.MAX_VALUE); // Dijkstra must fill the initial value with max value. to apply "min" method;
        Arrays.fill(wolfDist[1], Integer.MAX_VALUE); // slow = 1;
        PriorityQueue<Node> pq = new PriorityQueue<>(); // priority queue for sorting the next nodes;

        pq.offer(new Node(start, 0, 0)); // initializing the starting node with 0;
        wolfDist[0][start] = 0; // initializing the distance of myself;
        while (!pq.isEmpty()) {
            Node c = pq.poll();
            int current = c.next; // this is current node;
            int dir = c.dir;

            if (wolfDist[dir][current] <c.weight)
            continue;

            for (Node next :
                    Graph.get(current)) { // getting linked node from current node. its a list.
                int nextDir = (dir == 0) ? 1 : 0;
                long nextWeight = (dir == 0) ? next.weight / 2 : next.weight *2;
                if (wolfDist[nextDir][next.next] > c.weight + nextWeight) { // 방문하지 않았고, 다음번 갈 노드의 거리가 지금 온 노드를 거쳐서 가는 것 보다 멀다면.
                    wolfDist[nextDir][next.next] = c.weight + nextWeight;
                    pq.offer(new Node(next.next, c.weight + nextWeight, nextDir)); // 이거의 의미는 잘 모르겠는데;; 새로운 노드로 업데이트 하는 듯;
                }
            }

        }
    }

    static class Node implements Comparable<Node> { // classic class for node implementation. class with compare algo to use priority queue;
        int next;
        long weight;
        int dir;

        public Node(int next, long weight) {
            this.next = next;
            this.weight = weight;
        }

        public Node(int next, long weight, int dir) {
            this.next = next;
            this.weight = weight;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.weight - o.weight);
        }
    }

}
