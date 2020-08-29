package ru.mephi.java.part3.MyIterators;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyIterator3<V> {
    private final Iterator<?> iterator;
    private Function<V, ?> function;
    private MyIterator3<V> chainIterator;

    private <R> MyIterator3(Iterator<?> iterator, Function<V, R> function, MyIterator3<V> previousIterator) {
        this.function = function;
        this.chainIterator = previousIterator;
        this.iterator = iterator;
    }

    public static <V> MyIterator3<V> fromIterator(Iterator<V> iterator) {
        return new MyIterator3<>(iterator, Function.identity(), null);
    }

    @SuppressWarnings("unchecked")
    public V next() {
        return (V) this.function
                .apply((V) (Objects.nonNull(this.chainIterator) ? this.chainIterator.next() : this.iterator.next()));
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public <R> MyIterator3<R> map(Function<V, R> function) {
        return new MyIterator3(this.iterator, function, this);
    }

    public void forEach(Consumer<V> action) {
        while (hasNext()) {
            action.accept(this.next());
        }
    }
}
