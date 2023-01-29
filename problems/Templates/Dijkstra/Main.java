package Templates.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<ArrayList<Node>> Graph = new ArrayList<>(); // linked list for implement node graph. the index is the start node number;
    static int N, E; // about node and edges;
    public static void main(String[] args) {
        Graph.add(new ArrayList<>());
    }

    public void Dijkstra(int start, int end){
        int[] dist = new int[N+1]; // this means distance from start to end;
        Arrays.fill(dist, Integer.MAX_VALUE); // Dijkstra must fill the initial value with max value. to apply "min" method;
        boolean[] visited = new boolean[N+1]; // have to check if we visited or not;
        PriorityQueue<Node> pq = new PriorityQueue<>(); // priority queue for sorting the next nodes;

        pq.offer(new Node(start, 0)); // initializing the starting node with 0;
        dist[start] = 0; // initializing the distance of myself;
        while(!pq.isEmpty()){
            Node c = pq.poll();
            int current = c.next; // this is current node;
            if(!visited[current]){
                visited[current] = true;

                for (Node next:
                     Graph.get(current)) { // getting linked node from current node. its a list.
                    if(!visited[next.next] && dist[next.next] > dist[current] + next.weight){ // 방문하지 않았고, 다음번 갈 노드의 거리가 지금 온 노드를 거쳐서 가는 것 보다 멀다면.
                        dist[next.next] = dist[current] + next.weight;
                        pq.offer(new Node(next.next, dist[next.next])); // 이거의 의미는 잘 모르겠는데;; 새로운 노드로 업데이트 하는 듯;
                    }
                }

            }
        }

    }

    static class Node implements Comparable<Node>{ // classic class for node implementation. class with compare algo to use priority queue;
        int next;
        int weight;
        public Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

}
