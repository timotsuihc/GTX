import java.util.*;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        //initialize
        List<Vertex<T>> vistedList = new ArrayList<Vertex<T>>();
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        Vertex<T> currentNode;
        List<VertexDistance<T>> vertexDistances;

        queue.add(start);
        vistedList.add(start);
        while(queue.isEmpty() != true){
            currentNode =  queue.remove();
            //find current node adjacent
            vertexDistances = graph.getAdjList().get(currentNode);
//            System.out.println("currentNode: " + currentNode.toString());
//            System.out.println("VertexDistance: " + vertexDistances.toString());
//            System.out.println("visitedList: " + vistedList.toString());
//            System.out.println("Queue Before: "+ queue.toString());

            for (VertexDistance<T> vd : vertexDistances) {
                if (vistedList.contains(vd.getVertex()) != true){
                    queue.add(vd.getVertex());
                    vistedList.add(vd.getVertex());
                }
            }
//            System.out.println("Queue After: " + queue.toString());
//            System.out.println("");

        }

        return vistedList;

    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<Vertex<T>> vistedList = new ArrayList<Vertex<T>>();

        dfsMe(start, graph, vistedList);

        return vistedList;

    }

    private static <T> void dfsMe (Vertex<T> currentVertex, Graph<T> graph, List<Vertex<T>> visitedList){
        if (visitedList.size() == graph.getVertices().size()){
            return;
        }
        visitedList.add(currentVertex);
//        System.out.println("Current vertex: " + currentVertex.toString());
//        System.out.println(graph.getAdjList().get(currentVertex).toString());
//        System.out.println();
        for (VertexDistance<T> vd: graph.getAdjList().get(currentVertex)) {
            if (visitedList.contains(vd.getVertex()) != true){
                dfsMe(vd.getVertex(), graph, visitedList);
            }
        }
    }

    public static void main(String[] args) {
//        Set<Vertex<Integer>> vertexSet = new HashSet<>();
//        Set<Edge<Integer>> edgeSet = new HashSet<>();
//
//        //Add vertices
//        for (int i = 0; i < 10; i++) {
//            vertexSet.add(new Vertex<>(i));
//        }
//
//        List<Vertex<Integer>> vertexArray = new ArrayList<Vertex<Integer>>(vertexSet);
//
//        //make a binary tree with loop to 0 if even number of members
//        for (int i = 0; i < (vertexSet.size()/2); i++) {
//            edgeSet.add( new Edge<>(vertexArray.get(i), vertexArray.get(((i*2)+1)%vertexArray.size()), 1));
//            edgeSet.add( new Edge<>(vertexArray.get(i), vertexArray.get(((i*2)+2)%vertexArray.size()), 1));
//        }

        //default graph
        Set<Vertex<Character>> vertexSet = new HashSet<>();
        Set<Edge<Character>> edgeSet = new HashSet<>();


        HashMap<Character, Vertex<Character>> vertexHashMap = new HashMap<>();

        //vertexSet and vertexArray
        for (char i = 'A'; i <= 'H'; i++) {
            vertexSet.add(new Vertex<Character>(i));
            //mask hashmap instead of list
            vertexHashMap.put(i, new Vertex<>(i));
        }

        //List<Vertex<Character>> vertexArray = new ArrayList<Vertex<Character>>(vertexSet);


        //edgeSet
        edgeSet.add(new Edge<Character>(vertexHashMap.get('A'), vertexHashMap.get('B'), 1));

//        edgeSet.add(new Edge<Character>(new Vertex<Character>('A'), new Vertex<Character>('B'), 1));
//        edgeSet.add(new Edge<Character>(new Vertex<Character>('A'), new Vertex<Character>('C'), 1));
//        edgeSet.add(new Edge<Character>(new Vertex<Character>('A'), new Vertex<Character>('D'), 1));
//        edgeSet.add(new Edge<Character>(new Vertex<Character>('A'), new Vertex<Character>('E'), 1));

//        edgeSet.add(new Edge<Character>(vertexArray.get(0), vertexArray.get(1), 1));
//        edgeSet.add(new Edge<Character>(vertexArray.get(0), vertexArray.get(2), 1));
//        edgeSet.add(new Edge<Character>(vertexArray.get(0), vertexArray.get(3), 1));
//        edgeSet.add(new Edge<Character>(vertexArray.get(0), vertexArray.get(4), 1));
//        edgeSet.add(new Edge<Character>(vertexArray.get(1), vertexArray.get(6), 1));
//        edgeSet.add(new Edge<Character>(vertexArray.get(3), vertexArray.get(5), 1));
//        edgeSet.add(new Edge<Character>(vertexArray.get(5), vertexArray.get(6), 1));
//        edgeSet.add(new Edge<Character>(vertexArray.get(4), vertexArray.get(6), 1));
//        edgeSet.add(new Edge<Character>(vertexArray.get(6), vertexArray.get(7), 1));

        List<Edge<Character>> edgeArray = new ArrayList<Edge<Character>>(edgeSet);

        for (Edge<Character> edge: edgeArray) {
            edgeSet.add(new Edge<Character>(edge.getV(), edge.getU(), 1));
        }

//        System.out.println(vertexSet.toString());
//        System.out.println(edgeSet.toString());

        Graph<Character> graph = new Graph<Character>(vertexSet, edgeSet);
        //List<Vertex<Character>> returnedList = bfs(vertexArray.get(0), graph);
        List<Vertex<Character>> returnedList = dfs(vertexArray.get(0), graph);


        System.out.println(returnedList.toString());

    }
}