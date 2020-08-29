package ru.mephi.java.part3.MyIterators;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyIterator<K, V> {
    private final Iterator<K> iterator;
    private final Function<K, V> function;

    @SuppressWarnings("unchecked")
    public static <K, V> MyIterator<K, V> fromIterator(Iterator<K> iterator) {
        return new MyIterator<>(iterator, k -> (V) k);
    }

    private MyIterator(Iterator<K> iterator, Function<K, V> function) {
        this.iterator = iterator;
        this.function = function;
    }

    public V next() {
        return this.function.apply(iterator.next());
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public MyIterator<K, V> map(Function<V, V> function) {
        return new MyIterator<K, V>(this.iterator, this.function.andThen(function));
    }

    public void forEach(Consumer<V> action) {
        while (hasNext()) {
            action.accept(this.next());
        }
    }
}