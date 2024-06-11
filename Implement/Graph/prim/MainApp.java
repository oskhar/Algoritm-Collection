import java.util.Arrays;
import java.util.stream.Stream;

public class MainApp {

    public static void main(String[] args) {

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");

        Edge edgeAB = new Edge(10);
        Edge edgeAD = new Edge(15);
        Edge edgeBA = new Edge(10);
        Edge edgeBC = new Edge(20);
        Edge edgeBE = new Edge(13);
        Edge edgeCB = new Edge(20);
        Edge edgeCE = new Edge(5);
        Edge edgeCF = new Edge(12);
        Edge edgeDA = new Edge(15);
        Edge edgeDE = new Edge(11);
        Edge edgeDF = new Edge(16);
        Edge edgeEC = new Edge(5);
        Edge edgeEB = new Edge(13);
        Edge edgeED = new Edge(11);
        Edge edgeEF = new Edge(21);
        Edge edgeFD = new Edge(16);
        Edge edgeFE = new Edge(21);
        Edge edgeFC = new Edge(12);

        vertexA.addNeighbor(vertexB, edgeAB);
        vertexA.addNeighbor(vertexD, edgeAD);

        vertexB.addNeighbor(vertexA, edgeBA);
        vertexB.addNeighbor(vertexC, edgeBC);
        vertexB.addNeighbor(vertexE, edgeBE);

        vertexC.addNeighbor(vertexB, edgeCB);
        vertexC.addNeighbor(vertexE, edgeCE);
        vertexC.addNeighbor(vertexF, edgeCF);

        vertexD.addNeighbor(vertexA, edgeDA);
        vertexD.addNeighbor(vertexE, edgeDE);
        vertexD.addNeighbor(vertexF, edgeDF);

        vertexE.addNeighbor(vertexC, edgeEC);
        vertexE.addNeighbor(vertexB, edgeEB);
        vertexE.addNeighbor(vertexD, edgeED);
        vertexE.addNeighbor(vertexF, edgeEF);

        vertexF.addNeighbor(vertexD, edgeFD);
        vertexF.addNeighbor(vertexE, edgeFE);
        vertexF.addNeighbor(vertexC, edgeFC);

        new Prim<>(Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF)).run();

        Integer minimum = Stream.of(edgeAB, edgeAD, edgeBA, edgeBC, edgeBE, edgeCB, edgeCE, edgeCF, edgeDA, edgeDE, edgeDF, edgeEC, edgeEB, edgeED, edgeEF, edgeFD, edgeFE, edgeFC)
                .filter(Edge::isIncluded).map(Edge::getWeight).reduce(0, Integer::sum);
        System.out.println("Minimum Weight: " + minimum);

    }
}
