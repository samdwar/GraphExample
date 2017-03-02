/**
 * Created by sam on 28/2/17.
 */
public class Main {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        buildGraph(graph);
        System.out.println(graph.getEdge("LAX", "MIA"));

        System.out.println("<<DFS>>");
        graph.DFS("LAX");

        graph.clearVisitedNodes();
        System.out.println("<<BFS>>");
        graph.BFS("LAX");

        graph.clearVisitedNodes();
        System.out.println("Is Graph Cyclic: " + graph.isCyclic());
    }

    public static void buildGraph(Graph<String> g) {
        g.addVertex("LAX");
        g.addVertex("SFO");
        g.addVertex("DFW");
        g.addVertex("ORD");
        g.addVertex("MIA");
        g.addVertex("JFK");
        g.addVertex("BOS");

        g.addEdge("LAX", "ORD", 1500);
        g.addEdge("DFW", "LAX", 800);
        g.addEdge("DFW", "ORD", 600);
        g.addEdge("DFW", "SFO", 1100);
        g.addEdge("DFW", "JFK", 950);
//        g.addEdge("ORD", "DFW", 600);
        g.addEdge("MIA", "DFW", 1200);
        g.addEdge("MIA", "LAX", 2800);
//        g.addEdge("JFK", "MIA", 1300);
        g.addEdge("JFK", "SFO", 3600);
//        g.addEdge("JFK", "BOS", 300);
        g.addEdge("BOS", "JFK", 300);
        g.addEdge("BOS", "MIA", 1500);
    }
}
