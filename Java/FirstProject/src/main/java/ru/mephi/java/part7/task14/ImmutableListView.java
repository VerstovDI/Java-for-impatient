package ru.mephi.java.part7.task14;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ImmutableListView {

    private static class ImmutableListViewInner<Integer> implements List<Integer> {
        private int size;

        public ImmutableListViewInner(int size) {
            if (size < 0) {
                throw new IllegalArgumentException("Illegal argument! View size < 0!");
            }
            this.size = size;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean contains(Object o) {
            if (o != null   ) {
                return (int) o <= size;
            }
            return false;
        }

        @NotNull
        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @NotNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NotNull
        @Override
        public <T> T[] toArray(@NotNull T[] a) {
            return null;
        }

        @Override
        public boolean add(Integer integer) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public boolean containsAll(@NotNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NotNull Collection<? extends Integer> c) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public boolean addAll(int index, @NotNull Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(@NotNull Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(@NotNull Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Integer get(int index) {
            return null;
        }

        @Override
        public Integer set(int index, Integer element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(int index, Integer element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Integer remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @NotNull
        @Override
        public ListIterator<Integer> listIterator() {
            return null;
        }

        @NotNull
        @Override
        public ListIterator<Integer> listIterator(int index) {
            return null;
        }

        @NotNull
        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            return null;
        }
    }
}
