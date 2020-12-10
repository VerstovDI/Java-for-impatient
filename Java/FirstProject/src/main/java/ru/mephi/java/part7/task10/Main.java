package ru.mephi.java.part7.task10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DijkstraAlgorithms dijkstraAlgorithms = new DijkstraAlgorithms();
        dijkstraAlgorithms.findShortestPaths(makeSampleGraph());
        System.out.println(makeSampleGraph().entrySet());
        //System.out.println(...);
    }

    public static Map<String, Set<Neighbor>> makeSampleGraph() {
        Map<String, Set<Neighbor>> citiesGraph = new HashMap<>();
        HashSet<Neighbor> moscowHashSet = new HashSet<>();
        moscowHashSet.add(new Neighbor("Санкт-Петербург", 634));
        moscowHashSet.add(new Neighbor("Воронеж", 466));
        moscowHashSet.add(new Neighbor("Казань", 717));
        moscowHashSet.add(new Neighbor("Нижний Новгород", 401));
        citiesGraph.put("Москва", moscowHashSet);

        HashSet<Neighbor> spbHashSet = new HashSet<>();
        spbHashSet.add(new Neighbor("Москва", 634));
        spbHashSet.add(new Neighbor("Воронеж", 1073));
        spbHashSet.add(new Neighbor("Казань", 1198));
        citiesGraph.put("Санкт-Петербург", spbHashSet);

        HashSet<Neighbor> kazanHashSet = new HashSet<>();
        kazanHashSet.add(new Neighbor("Москва", 717));
        kazanHashSet.add(new Neighbor("Санкт-Петербург", 1198));
        kazanHashSet.add(new Neighbor("Воронеж", 796));
        kazanHashSet.add(new Neighbor("Нижний Новгород", 322));
        kazanHashSet.add(new Neighbor("Ростов-на-Дону", 1151));
        citiesGraph.put("Казань", kazanHashSet);

        HashSet<Neighbor> voronezhHashSet = new HashSet<>();
        voronezhHashSet.add(new Neighbor("Казань", 796));
        voronezhHashSet.add(new Neighbor("Москва", 466));
        voronezhHashSet.add(new Neighbor("Санкт-Петербург", 1073));
        citiesGraph.put("Воронеж", voronezhHashSet);

        HashSet<Neighbor> nizhnovgHashSet = new HashSet<>();
        nizhnovgHashSet.add(new Neighbor("Москва", 606));
        nizhnovgHashSet.add(new Neighbor("Казань", 322));
        nizhnovgHashSet.add(new Neighbor("Ростов-на-Дону", 1151));
        citiesGraph.put("Нижний Новгород", nizhnovgHashSet);

        HashSet<Neighbor> rostovDonHashSet = new HashSet<>();
        rostovDonHashSet.add(new Neighbor("Нижний Новгород", 1054));
        rostovDonHashSet.add(new Neighbor("Казань", 1151));
        citiesGraph.put("Ростов-на-Дону", rostovDonHashSet);
        return citiesGraph;
    }
}
