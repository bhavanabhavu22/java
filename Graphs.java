import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Graphs {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graphs() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(int v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
            
            for (int node : adjacencyList.keySet()) {
                if (node != v) {
                    addEdgeNoRecurse(node, v);
                }
            }
        }
    }
    
    private void addEdgeNoRecurse(int u, int v) {
        if (!adjacencyList.get(u).contains(v))
            adjacencyList.get(u).add(v);

        if (!adjacencyList.get(v).contains(u))
            adjacencyList.get(v).add(u);
    }


    //addEdge 
    public void addEdge(int u, int v) {
        addNode(u);
        addNode(v);

        if (!adjacencyList.get(u).contains(v))
            adjacencyList.get(u).add(v);

        if (!adjacencyList.get(v).contains(u))
            adjacencyList.get(v).add(u);
    }
    //Check Connections
    public boolean checkConnection(int u, int v) {
        if (adjacencyList.containsKey(v) && adjacencyList.get(v).contains(u)) {
            return true;
        }
        return false;
    }

    //Removes the Connections
    public void removeConnection(int u, int v) {
        if(adjacencyList.containsKey(v)) {
            adjacencyList.get(v).remove(Integer.valueOf(u));
        }
        if(adjacencyList.containsKey(u)) {
            adjacencyList.get(u).remove(Integer.valueOf(v));
        }
    }

    //count edges 
    public int countOfEdges() {
        int count=0;
        for (int node: adjacencyList.keySet()) {
            count += adjacencyList.get(node).size();
        }
        return count;
    }

    //count of the nodes
    public int countOfAdj(){
        int count=0;
        for(int v:adjacencyList.keySet()){
            count+=adjacencyList.get(v).size();

        }
        return count;
    }
    

    //print eaach node and number edges
    public void printNodeWithEdges() {
        for (int node : adjacencyList.keySet()) {
            int edges = adjacencyList.get(node).size();
            System.out.println(node+"->"+edges);
        }
    }


    //printing the graph
    public void printGraph() {
        for (int v : adjacencyList.keySet()) {
            System.out.println(v + "->"+ adjacencyList.get(v));
        }
    }

    public static void main(String[] args) {
        Graphs graph = new Graphs();

        graph.addNode(6);
        graph.addNode(1);
        graph.addNode(3);
        graph.addNode(5);
        graph.addNode(7);
        graph.addNode(8);
        graph.addNode(8);
        graph.addNode(6);
        graph.addNode(5);
        graph.addNode(7);
        graph.addNode(1);

        System.out.println("Graph");
        graph.printGraph();

        // Check connection
        System.out.println("connected " + graph.checkConnection(6, 3));
        System.out.println("connected " + graph.checkConnection(5, 2)); // false

        // Remove a connection
        System.out.println("Remove connection");
        graph.removeConnection(6, 3);

        System.out.println("connected " + graph.checkConnection(6, 3));

        // Print graph after removing
        System.out.println("Graph after removal:");
         graph.printGraph();

        // Count edges
        System.out.println("Total edges: " + graph.countOfEdges());
        
        //count of the nodes
        System.out.println("Total Nodes: " + graph.countOfAdj());

        //printing node and edges
        graph.printNodeWithEdges();

    }
}
