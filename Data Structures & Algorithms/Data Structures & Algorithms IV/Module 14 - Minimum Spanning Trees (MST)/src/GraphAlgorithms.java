import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Your implementation of Prim's algorithm.
 */
public class GraphAlgorithms {

    /**
     * Runs Prim's algorithm on the given graph and returns the Minimum
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     *
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     *
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * reverse edge to the set as well. This is for testing purposes. This
     * reverse edge does not need to be the one from the graph itself; you can
     * just make a new edge object representing the reverse edge.
     *
     * You may assume that there will only be one valid MST that can be formed.
     *
     * You should NOT allow self-loops or parallel edges in the MST.
     *
     * You may import/use java.util.PriorityQueue, java.util.Set, and any
     * class that implements the aforementioned interface.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * The only instance of java.util.Map that you may use is the adjacency
     * list from graph. DO NOT create new instances of Map for this method
     * (storing the adjacency list in a variable is fine).
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin Prims on.
     * @param graph The graph we are applying Prims to.
     * @return The MST of the graph or null if there is no valid MST.
     */
    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Edge<T>> MST = new HashSet<>();
        Set<Vertex<T>> visitedSet = new HashSet<>();
        PriorityQueue<Edge<T>> prioirtyQueue = new PriorityQueue<>();

        Vertex<T> currentVertex = start;
        visitedSet.add(start);

        while (graph.getVertices().size() != visitedSet.size()){

            //add current vertex edges to prioityQueue if destination not visited
            for (VertexDistance<T> vertexDiatance: graph.getAdjList().get(currentVertex)) {
                if (visitedSet.contains(vertexDiatance.getVertex()) != true){
                    prioirtyQueue.add(new Edge<T>(currentVertex, vertexDiatance.getVertex(), vertexDiatance.getDistance()));
                }
            }
            if (prioirtyQueue.isEmpty() == true){
                return null;
            }
            if (visitedSet.contains(prioirtyQueue.peek().getV()) != true){

                currentVertex = prioirtyQueue.peek().getV();
                visitedSet.add(currentVertex);
                MST.add(reverseEdge(prioirtyQueue.peek()));
                MST.add(prioirtyQueue.remove());
            }
            else{
                prioirtyQueue.remove();
            }
        }
        return MST;
    }

    private static <T> Edge<T> reverseEdge (Edge<T> edge){
        return new Edge<T>(edge.getV(), edge.getU(), edge.getWeight());
    }

    public static void main(String[] args) {
        Set<Vertex<Character>> vertexSet = new HashSet<>();
        HashMap<Character, Vertex<Character>> vertexHashMap = new HashMap<>();
        for (char i = 'A'; i <= 'H'; i++) {
            Vertex<Character> newVertex = new Vertex<>(i);
            vertexHashMap.put(i, newVertex);
            vertexSet.add(newVertex);
        }

        //System.out.println(vertexSet.toString());
        //System.out.println(vertexHashMap);

        Set<Edge<Character>> edgeSet = new HashSet<>();
        edgeSet.add(new Edge<>(vertexHashMap.get('A'), vertexHashMap.get('B'), 1));
        edgeSet.add(new Edge<>(vertexHashMap.get('A'), vertexHashMap.get('C'), 5));
        edgeSet.add(new Edge<>(vertexHashMap.get('B'), vertexHashMap.get('A'), 1));
        edgeSet.add(new Edge<>(vertexHashMap.get('B'), vertexHashMap.get('C'), 7));
        edgeSet.add(new Edge<>(vertexHashMap.get('B'), vertexHashMap.get('D'), 9));
        edgeSet.add(new Edge<>(vertexHashMap.get('B'), vertexHashMap.get('G'), 1));
        edgeSet.add(new Edge<>(vertexHashMap.get('C'), vertexHashMap.get('A'), 5));
        edgeSet.add(new Edge<>(vertexHashMap.get('C'), vertexHashMap.get('B'), 7));
        edgeSet.add(new Edge<>(vertexHashMap.get('C'), vertexHashMap.get('G'), 13));
        edgeSet.add(new Edge<>(vertexHashMap.get('D'), vertexHashMap.get('B'), 9));
        edgeSet.add(new Edge<>(vertexHashMap.get('D'), vertexHashMap.get('F'), 4));
        edgeSet.add(new Edge<>(vertexHashMap.get('E'), vertexHashMap.get('G'), 10));
        edgeSet.add(new Edge<>(vertexHashMap.get('F'), vertexHashMap.get('D'), 4));
        edgeSet.add(new Edge<>(vertexHashMap.get('F'), vertexHashMap.get('G'), 2));
        edgeSet.add(new Edge<>(vertexHashMap.get('F'), vertexHashMap.get('H'), 0));
        edgeSet.add(new Edge<>(vertexHashMap.get('G'), vertexHashMap.get('B'), 1));
        edgeSet.add(new Edge<>(vertexHashMap.get('G'), vertexHashMap.get('C'), 13));
        edgeSet.add(new Edge<>(vertexHashMap.get('G'), vertexHashMap.get('E'), 10));
        edgeSet.add(new Edge<>(vertexHashMap.get('G'), vertexHashMap.get('F'), 2));
        edgeSet.add(new Edge<>(vertexHashMap.get('G'), vertexHashMap.get('H'), 3));
        edgeSet.add(new Edge<>(vertexHashMap.get('H'), vertexHashMap.get('F'), 0));
        edgeSet.add(new Edge<>(vertexHashMap.get('H'), vertexHashMap.get('G'), 3));

        //System.out.println(edgeSet.toString());

        Graph<Character> graph = new Graph<>(vertexSet, edgeSet);
        Vertex<Character> starter = vertexHashMap.get('A');
        Set<Edge<Character>> primsEdges = prims(starter, graph);
        System.out.println(primsEdges.toString());


    }


}