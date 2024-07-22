package Implement.Graph.Kruskal;

import java.util.HashSet;
import java.util.Set;

public class Vertex<T> {

    private final T data;
    private boolean visited;
    private boolean beingVisited; // Tambahan field untuk mendeteksi siklus
    private Set<Vertex<T>> neighbors;

    public Vertex(T data) {
        this.data = data;
        this.visited = false;
        this.beingVisited = false; // Inisialisasi field tambahan
        this.neighbors = new HashSet<>();
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public Set<Vertex<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Set<Vertex<T>> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(Vertex<T> neighbor) {
        this.neighbors.add(neighbor);
    }
}
