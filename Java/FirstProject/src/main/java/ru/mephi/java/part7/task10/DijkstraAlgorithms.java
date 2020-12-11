package ru.mephi.java.part7.task10;

import java.util.*;

/**
 * Class that implements findShortestPaths DijkstraAlgorithm.
 * @author Verstov Danila
 * @version 1.0
 */
public class DijkstraAlgorithms {
    private Queue<Neighbour> unvisitedNodes
            = new PriorityQueue<>(Comparator.comparingInt(Neighbour::getDistance));  // Приоритетная очередь непосещённых вершин графа
    private Map<String, Set<Neighbour>> graph = new HashMap();  // Представляет входной граф
    private Map<String, Integer> distMap = new HashMap<>(); // Хранит актуальный данные о текущем наименьшем расстоянии от source

    public Map<String, Integer> findShortestPaths(Map<String, Set<Neighbour>> graph, String source) {

        // Step 0. Preparing & initialization step.
        //initUnvisited(graph, source);
        unvisitedNodes.add(new Neighbour(source, 0));
        initDistancesMap(graph, source);

        // Step 1. DijkstraAlgorithm
        while (!unvisitedNodes.isEmpty()) {
            Neighbour currNode = unvisitedNodes.poll();
            if (currNode != null) {
                for (Neighbour neighbour : graph.get(currNode.getCityName())) {
                    int newDist = distMap.get(currNode.getCityName()) + neighbour.getDistance();
                    if (newDist < distMap.get(neighbour.getCityName())) {
                        distMap.remove(neighbour.getCityName());
                        distMap.put(neighbour.getCityName(), newDist);
                        unvisitedNodes.add(new Neighbour(neighbour.getCityName(), newDist));
                    }
                }
            }
            unvisitedNodes.remove(currNode);
        }
        distMap.remove(source);
        return distMap;
    }

    private void initUnvisited(Map<String, Set<Neighbour>> graph, String source) {
        graph.forEach(
                (name, neighbors) -> {
                        if (name.equals(source)) {
                            unvisitedNodes.add(new Neighbour(source, 0));
                        } else {
                            unvisitedNodes.add(new Neighbour(name, Integer.MAX_VALUE));
                        }
                }
        );
    }

    private void initDistancesMap(Map<String, Set<Neighbour>> graph, String source) {
        graph.forEach(
                (name, neighbors) -> {
                    if (name.equals(source)) {
                        distMap.put(name, 0);
                    } else {
                        distMap.put(name, Integer.MAX_VALUE);
                    }
                }
        );
    }
}
