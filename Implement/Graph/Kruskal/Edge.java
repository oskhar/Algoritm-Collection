package Implement.Graph.Kruskal;

public class Edge<T> {

    private final Vertex<T> source;
    private final Vertex<T> destination;
    private final int weight;

    public Edge(Vertex<T> source, Vertex<T> destination, int weight) {
        if (source == null || destination == null) {
            throw new NullPointerException("Vertices cannot be null");
        }
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public Vertex<T> getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}