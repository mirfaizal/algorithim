package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;

public class GraphObject {

    class Vertex {
        String label;
        public Vertex(String label) {
            this.label = label;
        }
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Vertex)) {
                return false;
            }
            Vertex vertex = (Vertex) o;
            return label == vertex.label;
        }
        @Override
        public int hashCode()
        {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return String.format(label);
        }
    }

    private Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    private void addVertex(String label){
        adjVertices.put(new Vertex(label), new ArrayList<>());
    }

    // Undirected graph
    private void addEdge(String labelOne, String labelTwo){
        Vertex v1 = new Vertex(labelOne);
        Vertex v2 = new Vertex(labelTwo);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    private void removeVertex(GraphObject graph , String label){
        Vertex v = new Vertex(label);
        for(Map.Entry<Vertex, List<Vertex>> entry : graph.adjVertices.entrySet()){
            if(entry.getKey().equals(v)){
                // Remove Edges
                graph.adjVertices.values().stream().forEach(e -> e.remove(v));
                //Remove Vertex
                graph.adjVertices.remove(v);
            }
        }
    }

    // Undirected graph
    private void removeEdge(GraphObject graph , String parent, String child){
        Vertex parentVertex = new Vertex(parent);
        Vertex childVertex = new Vertex(child);
        List<Vertex> edgeList1 = graph.adjVertices.get(parentVertex);
        List<Vertex> edgeList2 = graph.adjVertices.get(childVertex);
        if(edgeList1 != null)   {edgeList1.remove(childVertex);}
        if(edgeList2 != null)   {edgeList2.remove(parentVertex);}
    }

    private List<Vertex> getAdjVertices(GraphObject graph , Vertex vertex){
        for(Map.Entry<Vertex,List<Vertex>> entry : graph.adjVertices.entrySet()){
            if(entry.getKey().equals(vertex)){
                return entry.getValue();
            }
        }
        return null;
    }

    private Set<Vertex> depthFirstTraversal(GraphObject graph , String root){
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(new Vertex(root));
        while(!stack.isEmpty()){
            Vertex vertex = stack.pop();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                // Loop through all adj vertices and push in stack
                if(getAdjVertices(graph, vertex) != null) {
                    for (Vertex adjVertex : getAdjVertices(graph,vertex)) {
                        stack.push(adjVertex);
                    }
                }
            }
        }
        return visited;
    }

    private Set<Vertex> breadthFirstTraversal(GraphObject graph, String label){
        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(label));
        visited.add(new Vertex(label));
        while(!queue.isEmpty()){
            Vertex vertex = queue.poll();
            List<Vertex> edges = getAdjVertices(graph,vertex);
            if(edges !=null) {
                for(Vertex edge : edges){
                    if(!visited.contains(edge)){
                        visited.add(edge);
                        queue.add(edge);
                    }
                }
            }
        }
        return visited;
    }


    private GraphObject createGraph(GraphObject graph) {
        graph.addVertex("HZaman");
        graph.addVertex("Afzal");
        graph.addVertex("Monir");
        graph.addVertex("Faizal");
        graph.addVertex("Jonefa");
        graph.addVertex("Alfa");
        graph.addVertex("Momtaz");
        graph.addVertex("Hasan");
        graph.addEdge("HZaman", "Afzal");
        graph.addEdge("HZaman", "Monir");
        graph.addEdge("Afzal", "Faizal");
        graph.addEdge("Afzal", "Jonefa");
        graph.addEdge("Monir", "Hasan");
        graph.addEdge("Monir", "Momtaz");
        graph.addEdge("Monir", "Alfa");
        return graph;
    }

    public static void main(String[] args) {
        GraphObject graph = new GraphObject();
        graph.createGraph(graph);
//        graph.removeVertex(graph,"Faizal");
//        graph.removeEdge(graph,"Seerat", "Stuti");
//        graph.removeEdge(graph,"Stuti", "Seerat");
        System.out.println(graph.breadthFirstTraversal(graph,"Hasan").toString());
        System.out.println(graph.breadthFirstTraversal(graph,"Faizal").toString());
        System.out.println(graph.depthFirstTraversal(graph,"Hasan").toString());
        System.out.println(graph.depthFirstTraversal(graph,"Faizal").toString());
    }
}
