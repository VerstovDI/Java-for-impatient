package ru.mephi.java.part7.task10;

import java.util.*;

/**
 * Class that implements findShortestPaths DijkstraAlgorithm.
 * @author Verstov Danila
 * @version 1.0
 */
public class DijkstraAlgorithms {
    /** PriorityQueue that holds Neighbors */
    private PriorityQueue<Neighbor> priorityQueue = new PriorityQueue<>();
    /** Map that represents graph of cities. Holds name of the city
     * and nearest cities (neighbours)
     * */
    private Map<String, Set<Neighbor>> graph = new HashMap();

    public List<String> findShortestPaths(Map<String, Set<Neighbor>> graph) {
        // TODO: доделать

        return Collections.emptyList();
    }
}
