package Implement.Graph.BellmanFord;

import java.util.HashMap;
import java.util.Map;

public class MainApp {

    // A class to represent a weighted edge in graph
    class Edge {
        int src, dest;
        double weight;
        Edge(int s, int d, double w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    int V, E;
    Edge edge[];
    Map<String, Integer> nodeMap = new HashMap<>();
    Map<Integer, String> reverseNodeMap = new HashMap<>();

    MainApp(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
    }

    void addEdge(int edgeIndex, String src, String dest, double weight) {
        int srcIndex = nodeMap.get(src);
        int destIndex = nodeMap.get(dest);
        edge[edgeIndex] = new Edge(srcIndex, destIndex, weight);
    }

    void BellmanFord(String startNode) {
        int src = nodeMap.get(startNode);
        double dist[] = new double[V];
        int[] parent = new int[V];  // To store the path

        for (int i = 0; i < V; ++i) {
            dist[i] = Double.MAX_VALUE;
            parent[i] = -1;
        }
        dist[src] = 0;

        System.out.println("Initial distances:");
        printArr(dist, V);

        for (int i = 1; i < V; ++i) {
            System.out.println("\nIteration " + i + ":");
            boolean updated = false;
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                double weight = edge[j].weight;
                if (dist[u] != Double.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;  // Store the path
                    System.out.println("Updated distance of vertex " + reverseNodeMap.get(v) + " to " + dist[v] + " using edge (" + reverseNodeMap.get(u) + ", " + reverseNodeMap.get(v) + ") with weight " + weight);
                    updated = true;
                } else {
                    System.out.println("No update for edge (" + reverseNodeMap.get(u) + ", " + reverseNodeMap.get(v) + ") with weight " + weight);
                }
            }
            if (!updated) {
                System.out.println("No updates in this iteration, stopping early.");
                break;
            }
            printArr(dist, V);
        }

        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            double weight = edge[j].weight;
            if (dist[u] != Double.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        printArr(dist, V);
        printPath(parent, src);
    }

    void printArr(double dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(reverseNodeMap.get(i) + "\t\t" + dist[i]);
    }

    void printPath(int[] parent, int src) {
        System.out.println("Minimum route from source:");
        for (int i = 0; i < parent.length; i++) {
            if (i != src && parent[i] != -1) {
                printRoute(i, parent);
                System.out.println(" = " + calculateDistance(i, parent));
            }
        }
    }

    void printRoute(int current, int[] parent) {
        if (parent[current] == -1) {
            System.out.print(reverseNodeMap.get(current));
            return;
        }
        printRoute(parent[current], parent);
        System.out.print(" -> " + reverseNodeMap.get(current));
    }

    double calculateDistance(int current, int[] parent) {
        double distance = 0;
        while (parent[current] != -1) {
            for (Edge e : edge) {
                if (e.src == parent[current] && e.dest == current) {
                    distance += e.weight;
                    break;
                }
            }
            current = parent[current];
        }
        return distance;
    }

    public static void main(String[] args) {
        int V = 10; // Number of vertices in graph
        int E = 10;  // Number of edges in graph

        MainApp graph = new MainApp(V, E);

        // Adding nodes
        String[] nodes = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < nodes.length; i++) {
            graph.nodeMap.put(nodes[i], i);
            graph.reverseNodeMap.put(i, nodes[i]);
        }

        // Adding edges
        graph.addEdge(0, "A", "C", 1.4);
        graph.addEdge(1, "C", "D", 0.2);
        graph.addEdge(2, "D", "E", 0.5);
        graph.addEdge(3, "E", "F", 0.6);
        graph.addEdge(4, "A", "H", 1.5);
        graph.addEdge(5, "H", "I", 3.4);
        graph.addEdge(6, "I", "J", 1.1);
        graph.addEdge(7, "J", "G", 2.3);
        graph.addEdge(8, "F", "G", 2.3);
        graph.addEdge(9, "G", "B", 1.5);

        // Function call
        graph.BellmanFord("A");
    }
}
