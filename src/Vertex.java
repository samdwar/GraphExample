/**
 * Created by sam on 28/2/17.
 */
public class Vertex<V> {
    private V v;
    private boolean isVisited;

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Vertex(V v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "< Vertex = " + v + " > ";
    }
}
