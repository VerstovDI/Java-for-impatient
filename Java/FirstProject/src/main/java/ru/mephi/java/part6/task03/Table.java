package ru.mephi.java.part6.task03;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Objects;

public class Table<K, V> {
    private ArrayList<Entry<K, V>> entryList;

    public Table() {
        entryList = new ArrayList<>();
    }

    public void add(Entry<K, V> entry) {
        entryList.add(entry);
    }

    //Hashtable
    public V get(K key) {
        return Objects.requireNonNull(entryList.stream()
                .filter(s -> s.getKey() == key)
                .findFirst()
                .orElse(null))
                .getValue();
    }

    public void set(K key, V value) {
        Objects.requireNonNull(entryList.stream()
                .filter(s -> s.getKey().equals(key))
                .findFirst()
                .orElse(null))
                .setValue(value);
    }

    public void remove(K key) {
        entryList.removeIf(entry -> entry.getKey().equals(key));
    }

    /* Вариант с возвращением удаляемого по ключу Entry
    public V remove2(K key) {
        for (Iterator<Entry<K, V>> iterator = entryList.iterator(); iterator.hasNext();) {
            Entry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                iterator.remove();
                return entry.getValue();
            }
        }
        return null;
    }
    */

    @Override
    public String toString() {
        return "Table{" +
                "entryList=" + entryList +
                '}';
    }
}
