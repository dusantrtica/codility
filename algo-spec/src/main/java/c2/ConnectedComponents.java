package c2;

import java.util.LinkedList;
import java.util.List;

public class ConnectedComponents {
    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(3, 5);
        graph.addEdge(5, 7);
        graph.addEdge(7, 9);
        graph.addEdge(0, 2);
        graph.addEdge(2, 4);
        graph.addEdge(6, 8);
        graph.addEdge(8, 10);
        graph.addEdge(10, 6);

        List<List<Integer>> partitions = graph.connectedComponents();
        for(List<Integer> partition : partitions) {
            for(int component : partition) {
                System.out.print(component + " ");
            }
            System.out.println();
        }
    }

    public static class Graph {
        int v;
        LinkedList<Integer>[] adj;

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                this.adj[i] = new LinkedList<>();
            }
        }

        public List<List<Integer>> connectedComponents() {
            boolean[] visited = new boolean[this.v];
            List<List<Integer>> partitions = new LinkedList<>();
            for (int i = 0; i < v; i++) {
                int start = i;
                if (visited[start]) {
                    continue;
                }

                LinkedList<Integer> components = new LinkedList<>();
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(start);
                visited[start] = true;
                components.add(start);

                while (!queue.isEmpty()) {
                    int vertex = queue.poll();
                    for (int elem : this.adj[vertex]) {
                        if (!visited[elem]) {
                            components.add(elem);
                            visited[elem] = true;
                            queue.add(elem);
                        }
                    }
                }

                partitions.add(components);

            }

            return partitions;
        }

        public void addEdge(int v, int w) {
            this.adj[v].add(w);
        }
    }
}
