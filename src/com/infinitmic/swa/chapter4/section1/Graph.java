package com.infinitmic.swa.chapter4.section1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

@SuppressWarnings("unchecked")
public class Graph implements GraphInterface {

    private final int vertices;
    protected int edges;
    private Bag<Integer>[] adjacent;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacent = (Bag<Integer>[]) new Bag[vertices];

        for(int vertex = 0; vertex < vertices; vertex++) {
            adjacent[vertex] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int edges = in.readInt();

        for(int i = 0; i < edges; i++) {
            int vertex1 = in.readInt();
            int vertex2 = in.readInt();
            addEdge(vertex1, vertex2);
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacent[vertex1].add(vertex2);
        adjacent[vertex2].add(vertex1);
        edges++;
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int edges() {
        return edges;
    }

    public Bag<Integer>[] getAdjacencyList() {
        return adjacent;
    }

    public void updateAdjacencyList(int vertex, Bag adjacencyList) {
        adjacent[vertex] = adjacencyList;
    }

    @Override
    public Iterable<Integer> adjacent(int vertex) {
        return adjacent[vertex];
    }

    public int degree(int vertex) {
        return adjacent[vertex].size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int vertex = 0; vertex < vertices(); vertex++) {
            stringBuilder.append(vertex).append(": ");

            for(int neighbour : adjacent(vertex)) {
                stringBuilder.append(neighbour).append(" ");
            }
            stringBuilder.append("\n")
        }

        return stringBuilder.toString();
    }
}
