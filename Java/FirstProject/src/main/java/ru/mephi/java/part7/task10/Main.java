package ru.mephi.java.part7.task10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DijkstraAlgorithms dijkstraAlgorithms = new DijkstraAlgorithms();
        System.out.println(makeSampleGraph().entrySet());
        System.out.println(dijkstraAlgorithms.findShortestPaths(makeSampleGraph(), "Воронеж"));


    }

    public static Map<String, Set<Neighbour>> makeSampleGraph() {
        Map<String, Set<Neighbour>> citiesGraph = new HashMap<>();
        HashSet<Neighbour> moscowHashSet = new HashSet<>();
        moscowHashSet.add(new Neighbour("Санкт-Петербург", 634));
        moscowHashSet.add(new Neighbour("Воронеж", 466));
        moscowHashSet.add(new Neighbour("Казань", 717));
        moscowHashSet.add(new Neighbour("Нижний Новгород", 401));
        citiesGraph.put("Москва", moscowHashSet);

        HashSet<Neighbour> spbHashSet = new HashSet<>();
        spbHashSet.add(new Neighbour("Москва", 634));
        spbHashSet.add(new Neighbour("Воронеж", 1073));
        spbHashSet.add(new Neighbour("Казань", 1198));
        citiesGraph.put("Санкт-Петербург", spbHashSet);

        HashSet<Neighbour> kazanHashSet = new HashSet<>();
        kazanHashSet.add(new Neighbour("Москва", 717));
        kazanHashSet.add(new Neighbour("Санкт-Петербург", 1198));
        kazanHashSet.add(new Neighbour("Воронеж", 796));
        kazanHashSet.add(new Neighbour("Нижний Новгород", 322));
        kazanHashSet.add(new Neighbour("Ростов-на-Дону", 1151));
        citiesGraph.put("Казань", kazanHashSet);

        HashSet<Neighbour> voronezhHashSet = new HashSet<>();
        voronezhHashSet.add(new Neighbour("Казань", 796));
        voronezhHashSet.add(new Neighbour("Москва", 466));
        voronezhHashSet.add(new Neighbour("Санкт-Петербург", 1073));
        citiesGraph.put("Воронеж", voronezhHashSet);

        HashSet<Neighbour> nizhnovgHashSet = new HashSet<>();
        nizhnovgHashSet.add(new Neighbour("Москва", 606));
        nizhnovgHashSet.add(new Neighbour("Казань", 322));
        nizhnovgHashSet.add(new Neighbour("Ростов-на-Дону", 1151));
        citiesGraph.put("Нижний Новгород", nizhnovgHashSet);

        HashSet<Neighbour> rostovDonHashSet = new HashSet<>();
        rostovDonHashSet.add(new Neighbour("Нижний Новгород", 1054));
        rostovDonHashSet.add(new Neighbour("Казань", 1151));
        citiesGraph.put("Ростов-на-Дону", rostovDonHashSet);
        return citiesGraph;
    }
}
