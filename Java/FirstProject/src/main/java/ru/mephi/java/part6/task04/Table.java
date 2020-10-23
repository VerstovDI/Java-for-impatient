package ru.mephi.java.part6.task04;

import ru.mephi.java.part6.task03.Entry;

import java.util.ArrayList;
import java.util.Objects;

public class Table<K, V> {
    private ArrayList<Entry> entryList;

    /* TODO: если вложенный (не статический внутренний), то не нужно - т.к.
    объемлющий класс имеет доступ ко всем полям вложенного.
    Если статический внутренний - то нужно, ведь имеем доступ только к статическим полям!
     */

    private class Entry {
        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public Table() {
        entryList = new ArrayList<>();
    }

    public void add(K key, V value) {
        entryList.add(new Entry(key, value));
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
