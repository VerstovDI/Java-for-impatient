package ru.mephi.java.part7.task16;


import org.jetbrains.annotations.NotNull;
import ru.mephi.java.part7.task13.Cache;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class ImmutableListViewAPI {

    public static ImmutableListView getImmutableListView(int i, IntFunction<Integer> intFunction) {
        return new ImmutableListView(i, intFunction);
    }

    static class ImmutableListView implements List<Integer> {
        private final int upperBound;
        private final int offset;
        private final IntFunction<Integer> intFunction;
        private Cache<Integer, Integer> cache = new Cache<>();

        public ImmutableListView(int upperBound, IntFunction<Integer> intFunction) {
            if (upperBound < 0) {
                throw new IllegalArgumentException("Illegal argument! Upper bound < 0!");
            }
            this.upperBound = upperBound;
            this.intFunction = intFunction;
            offset = 0;
        }

        public ImmutableListView(int size, int lastElement, IntFunction<Integer> intFunction) {
            if (size < 0 || lastElement < 0) {
                throw new IllegalArgumentException("Illegal argument! View size <= 0!");
            }
            upperBound = lastElement;
            this.intFunction = intFunction;
            offset = size;
        }

        private int checkInCache(int index) {
            if (cache.containsKey(index)) {
                System.out.println(" -- Value from cache -- ");
                return cache.get(index);
            } else {
                int result = intFunction.apply(index);
                cache.put(index, result);
                return result;
            }
        }

        @Override
        public int size() {
            return upperBound - offset + 1;
        }

        @Override
        public boolean isEmpty() {
            return upperBound - offset + 1 == 0;
        }

        @Override
        public boolean contains(Object o) {
            if (o instanceof Integer) {
                for (int i = offset; i <= upperBound; i++) {
                    if (checkInCache(i) == (int) o) {
                        return true;
                    }
                }
            }
            return false;
        }

        @NotNull
        @Override
        public Iterator<Integer> iterator() {
            return listIterator();
        }

        @Override
        public int indexOf(Object o) {
            if (o instanceof Integer) {
                int i = (int) o;
                for (int j = offset; i <= upperBound; i++) {
                    if (checkInCache(i) == i) {
                        return i - offset;
                    }
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            int index = -1;
            if (o instanceof Integer) {
                int i = (int) o;
                for (int j = offset; i <= upperBound; i++) {
                    if (checkInCache(i) == i) {
                        index = i - offset;
                    }
                }
            }
            return indexOf(o);
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            for (int i = offset; i <= upperBound; i++)
                action.accept(checkInCache(i));
        }

        @NotNull
        @Override
        public ListIterator<Integer> listIterator() {
            return listIterator(offset - 1);
        }

        @NotNull
        @Override
        public ListIterator<Integer> listIterator(int index) {
            if (index < offset - 1 || index > upperBound) {
                throw new IndexOutOfBoundsException("Illegal value of index: "
                        + index + "is out of available range");
            }
            return new ListIterator<>() {
                private int currentValue = index;

                @Override
                public boolean hasNext() {
                    return currentValue < upperBound;
                }

                @Override
                public Integer next() {
                    if (hasNext()) {
                        return checkInCache(++this.currentValue);
                    }
                    throw new IndexOutOfBoundsException("No next value");
                }

                @Override
                public boolean hasPrevious() {
                    return currentValue > index;
                }

                @Override
                public Integer previous() {
                    if (hasPrevious()) {
                        return checkInCache(--currentValue);
                    }
                    throw new IndexOutOfBoundsException("No next value");
                }

                @Override
                public int nextIndex() {
                    return currentValue + 1;
                }

                @Override
                public int previousIndex() {
                    return currentValue - 1;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("This view is unmodifiable!");
                }

                @Override
                public void set(Integer integer) {
                    throw new UnsupportedOperationException("This view is unmodifiable!");
                }

                @Override
                public void add(Integer integer) {
                    throw new UnsupportedOperationException("This view is unmodifiable!");
                }
            };
        }

        @NotNull
        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            if (toIndex < fromIndex || toIndex > upperBound - offset + 1
                    || fromIndex < 0) {
                throw new IndexOutOfBoundsException("Illegal index(-es). Out of bounds" + (upperBound - offset + 1));
            }
            return new ImmutableListView(offset + fromIndex, offset + toIndex - 1, intFunction);
        }

        @NotNull
        @Override
        public Object[] toArray() {
            Integer[] array = new Integer[upperBound - offset + 1];
            int j = 0;
            for (int i = offset; i <= upperBound; i++) {
                array[j++] = checkInCache(i);
            }
            return array;
        }

        @NotNull
        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(@NotNull T[] a) {
            Object[] array;
            int j = 0;
            if (a.length > upperBound - offset + 1) {
                array = (Object[]) Array.newInstance(a.getClass().getComponentType(), upperBound - offset + 1);
                for (int i = offset; i <= upperBound; i++) {
                    array[j++] = checkInCache(i);
                }
            } else {
                array = (Object[]) Array.newInstance(a.getClass().getComponentType(), upperBound - offset + 1);
                for (int i = offset; i < a.length + offset; i++) {
                    array[j++] = checkInCache(i);
                }
                for (int i = a.length + offset; i <= upperBound; i++) {
                    array[j++] = null;
                }
            }
            return (T[]) array;
        }

        @Override
        public Integer get(int index) {
            if (index + offset <= upperBound && index >= 0) {
                return checkInCache(index + offset);
            }
            throw new IndexOutOfBoundsException("Current index "
                    + index + " is out of bound " + (upperBound - offset));
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
            for (Object o : c) {
                if (!contains(o)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(@NotNull Collection<? extends Integer> c) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public boolean addAll(int index, @NotNull Collection<? extends Integer> c) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public boolean removeAll(@NotNull Collection<?> c) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public boolean retainAll(@NotNull Collection<?> c) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public Integer set(int index, Integer element) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public void add(int index, Integer element) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }

        @Override
        public Integer remove(int index) {
            throw new UnsupportedOperationException("This view is unmodifiable!");
        }
    }
}


