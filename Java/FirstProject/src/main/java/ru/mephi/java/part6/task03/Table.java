package ru.mephi.java.part6.task03;

import java.util.ArrayList;
import java.util.Hashtable;

public class Table<K, V> {
    private ArrayList<Entry<K, V>> entryList;

    public Table() {
        entryList = new ArrayList<>();
    }

    //Hashtable
    public V get(K key) {
        return entryList.stream()
                .filter(s -> s.getKey() == key)
                .findFirst()
                .orElse(null)
                .getValue();
    }
}
