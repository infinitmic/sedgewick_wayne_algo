package com.infinitmic.swa.chapter4.section1;

public class Cycle {

    private boolean[] visited;
    private boolean hasCycle;

    public Cycle(Graph graph) {
        visited = new boolean[graph.vertices()];

        for(int source = 0; source < graph.vertices(); source++) {
            if(!visited[source]) {
                dfs(graph, source, source);
            }
        }
    }

    private void dfs(Graph graph, int vertex, int origin) {
        visited[vertex] = true;

        for(int neighbour : graph.adjacent(vertex)) {
            if (!visited[neighbour]) {
                dfs(graph, neighbour, vertex);
            } else if (neighbour != origin) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
