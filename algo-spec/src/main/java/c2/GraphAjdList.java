package c2;

import java.util.LinkedList;

public class GraphAjdList {

  private final int v;
  private final LinkedList<Integer>[] adj;

  public GraphAjdList(int v) {
    this.v = v;
    this.adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      this.adj[i] = new LinkedList<>();
    }
  }

  public static void g1() {
    GraphAjdList graph = new GraphAjdList(6);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);
    graph.addEdge(2, 4);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(3, 5);

    graph.bfs(0);

  }

  public static void g2() {
    GraphAjdList graph = new GraphAjdList(6);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);
    graph.addEdge(2, 4);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(3, 5);

    for(int e : graph.shortestPaths(0)) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    System.out.println("--------------");
    g1();
    System.out.println("--------------");
    g2();
  }

  public void addEdge(int v, int w) {
    this.adj[v].add(w);
  }

  public void bfs(int start) {
    boolean[] visited = new boolean[this.v];
    LinkedList<Integer> queue = new LinkedList<>();

    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      System.out.print(node);
      visited[node] = true;
      for (int elem : this.adj[node]) {
        if (!visited[elem]) {
          queue.add(elem);
        }
      }
    }

    System.out.println(" X ");
  }

  public int [] shortestPaths(int start) {
    boolean[] visited = new boolean[this.v];
    int[] distances = new int[this.v];
    for (int i = 0; i < this.v; i++) {
      distances[i] = i == start ? 0 : Integer.MAX_VALUE;
    }

    LinkedList<Integer> queue = new LinkedList<>();
    visited[start] = true;
    queue.add(start);

    while(!queue.isEmpty()) {
      int vertex = queue.poll();
      for(int elem : this.adj[vertex]) {
        if(!visited[elem]) {
          visited[elem] = true;
          queue.add(elem);
          distances[elem] = distances[vertex] + 1;
        }
      }
    }

    return distances;
  }

}
