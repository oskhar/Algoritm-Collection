package Implement.Graph.Fulkerson;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        // Membuat vertex
        Vertex<String> S = new Vertex<>("S");
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> T = new Vertex<>("T");

        // Menambahkan edge dengan kapasitas (weight)
        S.addNeighbor(A, 15);
        S.addNeighbor(B, 12);
        A.addNeighbor(B, 10);
        A.addNeighbor(C, 12);
        A.addNeighbor(D, 1);
        B.addNeighbor(D, 14);
        C.addNeighbor(T, 25);
        D.addNeighbor(C, 10);
        D.addNeighbor(T, 4);

        // Menjalankan algoritma Ford-Fulkerson
        FordFulkerson<String> fordFulkerson = new FordFulkerson<>();
        int maxFlow = fordFulkerson.run(S, T);

        // Mencetak semua jalur yang ditemukan selama proses Ford-Fulkerson
        System.out.println("\nPaths found during Ford-Fulkerson:");
        fordFulkerson.getPaths().forEach(path -> {
            System.out.println(pathToString(path) + " with min capacity " + fordFulkerson.getMinFlowInPath(path));
        });

        // Mencetak hasil aliran maksimum
        System.out.println("The Max Flow is: " + maxFlow);
    }

    // Method untuk mencetak graf
    public static <T> void printGraph(Vertex<T> source) {
        System.out.println("Vertices and their neighbors:");
        printGraphHelper(source, new ArrayList<>());
    }

    private static <T> void printGraphHelper(Vertex<T> vertex, List<Vertex<T>> visited) {
        if (visited.contains(vertex)) return;
        visited.add(vertex);
        System.out.println(vertex.getData() + ": " + vertex.getNeighbors());
        for (Vertex<T> neighbor : vertex.getNeighbors().keySet()) {
            printGraphHelper(neighbor, visited);
        }
    }

    // Method untuk mengubah jalur ke string
    public static <T> String pathToString(List<Vertex<T>> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size() - 1; i++) {
            sb.append(path.get(i).getData()).append(" -> ");
        }
        sb.append(path.get(path.size() - 1).getData());
        return sb.toString();
    }
}
