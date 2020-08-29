package ru.mephi.java.lectureExamples.crazyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyIterator2<K> {

    private Iterator<K> iterator;
    private List<Function<K, ?>> functions;

    public static <K> MyIterator2<K> fromIterator(Iterator<K> iterator) {
        return new MyIterator2<>(iterator);
    }

    private MyIterator2(Iterator<K> iterator) {
        this.iterator = iterator;
        functions = new ArrayList<>();
    }

    private MyIterator2(Iterator<K> iterator, Function<K, ?> function) {
        this.iterator = iterator;
        functions = new ArrayList<>();
        functions.add(function);
    }

    private MyIterator2(Iterator<K> iterator, List<Function<K, ?>> functions) {
        this.iterator = iterator;
        this.functions = functions;
    }

    public Object next() {
        K key = iterator.next();
        Object val = null;
        for (Function<K, ?> function : functions) {
            val = function.apply(key);
            key = (K) val;
        }
        return val;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public <R> MyIterator2<R> map(Function<K, R> function) {
        List<Function<K, ?>> functions2 = this.functions;
        functions2.add(function);
        return new MyIterator2(iterator, functions2);
    }

    public void forEach(Consumer<Object> action) {
        while (hasNext()) {
            action.accept(next());
        }
    }
}