package ru.mephi.java.part7.task13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K, V> extends LinkedHashMap<K, V> {
    private int max_entries = 10;

    public Cache() {
        super();
    }

    public Cache(int max_entries) {
        super();
        this.max_entries = max_entries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > max_entries;
    }

    public int getMax_entries() {
        return max_entries;
    }

    public void setMax_entries(int max_entries) {
        this.max_entries = max_entries;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "max_entries=" + max_entries +
                '}';
    }
}
