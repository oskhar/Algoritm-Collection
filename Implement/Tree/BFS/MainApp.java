package Implement.Tree.BFS;

public class MainApp {

    public static void main(String[] args) {

        // Definisikan node sesuai dengan nama node dalam kasus
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");
        Vertex<String> G = new Vertex<>("G");
        Vertex<String> H = new Vertex<>("H");
        Vertex<String> I = new Vertex<>("I");
        Vertex<String> J = new Vertex<>("J");

        // Tetapkan neighbors sesuai dengan rute yang diberikan
        A.addNeighbor(C);
        A.addNeighbor(H);
        C.addNeighbor(D);
        D.addNeighbor(E);
        E.addNeighbor(F);
        F.addNeighbor(G);
        G.addNeighbor(B);
        H.addNeighbor(I);
        I.addNeighbor(J);
        J.addNeighbor(G);

        // Mulai traversal BFS dari node A
        new BreadthFirstSearch<>(A).traverse();
    }
}
