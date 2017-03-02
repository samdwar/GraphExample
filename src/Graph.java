import java.util.*;

/**
 * Created by sam on 28/2/17.
 */
public class Graph<V> {
    private Map<V, List<Edge<V>>> adjacencyListMap; // [vertices->edge]
    private Map<V, Vertex<V>> vertexMap; // [vertex->info]

    public Graph() {
        adjacencyListMap = new HashMap<V, List<Edge<V>>>();
        vertexMap = new HashMap<V, Vertex<V>>();
    }

    public void addVertex(V v) {
        if (v == null) {
            throw new IllegalArgumentException("Vertex can't be null");
        }
        adjacencyListMap.put(v, new ArrayList<Edge<V>>());
        vertexMap.put(v, new Vertex<V>(v));
    }

    public void addEdge(V from, V to, int weight) {
        if (from == null || to == null) throw new IllegalArgumentException("null");
        List<Edge<V>> edgeList = adjacencyListMap.get(from);
        Edge<V> edge = new Edge<V>(from, to, weight);
        edgeList.add(edge);
    }

    public Edge<V> getEdge(V from, V to) {
        if (from == null || to == null) throw new IllegalArgumentException("null");
        List<Edge<V>> edgeList = adjacencyListMap.get(from);

        if (edgeList == null || edgeList.size() == 0) throw new IllegalAccessError("Edge not found");
        for (Edge<V> edge : edgeList) {
            if (edge.getTo().equals(to)) {
                return edge;
            }
        }
        return null;
    }

    public void DFS(V from) {
        Vertex<V> vertex = vertexMap.get(from);
        vertex.setVisited(true);
        System.out.println(vertex);
        List<Edge<V>> edgeList = adjacencyListMap.get(from);
        for (Edge edge : edgeList) {
            Vertex<V> nextVertex = vertexMap.get(edge.getTo());
            if (nextVertex.isVisited() == false) {
                DFS(nextVertex.getV());
            }
        }
    }

    public void BFS(V from) {
        Vertex<V> vertex = vertexMap.get(from);
        vertex.setVisited(true);
        Queue<Vertex<V>> vertexQueue = new LinkedList<>();
        vertexQueue.add(vertex);
        while (!vertexQueue.isEmpty()) {
            Vertex<V> currentVertex = vertexQueue.poll();
            System.out.println(currentVertex);
            List<Edge<V>> edgeList = adjacencyListMap.get(currentVertex.getV());
            for (Edge<V> edge : edgeList) {
                Vertex<V> nextVertex = vertexMap.get(edge.getTo());
                if (!nextVertex.isVisited()) {
                    nextVertex.setVisited(true);
                    vertexQueue.add(nextVertex);
                }
            }
        }
    }

    public void clearVisitedNodes() {
        for (Vertex<V> vertex : vertexMap.values()) {
            vertex.setVisited(false);
        }
    }

    public boolean isCyclic() {
        Map<V, Boolean> recStackMap = new HashMap<V, Boolean>();
        for (Vertex<V> vertex : vertexMap.values()) {
            if (isCyclicUtils(vertex, recStackMap)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCyclicUtils(Vertex<V> vertex, Map<V, Boolean> recStackMap) {
        vertex.setVisited(true);
        recStackMap.put(vertex.getV(), true);
        List<Edge<V>> edgeList = adjacencyListMap.get(vertex.getV());
        for (Edge<V> edge : edgeList) {
            Vertex<V> nextVertex = vertexMap.get(edge.getTo());
            if(!nextVertex.isVisited() && isCyclicUtils(nextVertex, recStackMap)){
                return true;
            }else if(recStackMap.get(nextVertex.getV())){
                return true;
            }
        }

        recStackMap.put(vertex.getV(), false);
        return false;
    }
}
