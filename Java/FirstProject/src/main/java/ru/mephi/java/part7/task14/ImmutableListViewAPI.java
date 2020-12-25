package ru.mephi.java.part7.task14;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class ImmutableListViewAPI {

    public static ImmutableListView getImmutableListView(int i) {
        return new ImmutableListView(i);
    }

    static class ImmutableListView implements List<Integer> {
        private final int upperBound;  // Верхняя граница последовательности
        private final int lowerBound;  // Нижняя граница последовательности

        public ImmutableListView() {
            lowerBound = upperBound = 0;
        }

        public ImmutableListView(int upperBound) {
            if (upperBound < 0) {
                throw new IllegalArgumentException("Illegal argument! Upper bound < 0!");
            }
            this.upperBound = upperBound;
            lowerBound = 0;
        }

        public ImmutableListView(int lowerBound, int upperBound) {
            if (lowerBound > upperBound) {
                throw new IllegalArgumentException("" +
                        "Illegal argument! lower bound can't be more than upper bound");
            }
            this.upperBound = upperBound;
            this.lowerBound = lowerBound;
        }

        @Override
        public int size() {
            return upperBound - lowerBound + 1;
        }

        @Override
        public boolean isEmpty() {
            return upperBound - lowerBound == 0;
        }

        @Override
        public boolean contains(Object o) {
            if (o instanceof Integer) {
                return lowerBound <= (int) o && (int) o <= upperBound;
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
                if (i <= upperBound && i >= lowerBound) {
                    return i - lowerBound;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            return indexOf(o);
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            for (int i = lowerBound; i <= upperBound; i++)
                action.accept(i);
        }

        @NotNull
        @Override
        public ListIterator<Integer> listIterator() {
            return listIterator(0);
        }

        @NotNull
        @Override
        public ListIterator<Integer> listIterator(int index) {
            if (index < 0 || index > upperBound - lowerBound) {
                throw new IndexOutOfBoundsException("Illegal value of index: "
                        + index + "is out of available range");
            }
            return new ListIterator<>() {
                private int currentIndex = index;

                @Override
                public boolean hasNext() {
                    return currentIndex <= upperBound - lowerBound;
                }

                @Override
                public Integer next() {
                    if (hasNext()) {
                        return lowerBound + currentIndex++;
                    }
                    throw new IndexOutOfBoundsException("No next value");
                }

                @Override
                public boolean hasPrevious() {
                    return currentIndex > 0;
                }

                @Override
                public Integer previous() {
                    if (hasPrevious()) {
                        return lowerBound + --currentIndex;
                    }
                    return -1;
                }

                @Override
                public int nextIndex() {
                    if (currentIndex >= upperBound - lowerBound) {
                        return -1;
                    }
                    return currentIndex + 1;
                }

                @Override
                public int previousIndex() {
                    if (currentIndex == 0) {
                        return -1;
                    }
                    return currentIndex - 1;
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
            if (toIndex < fromIndex || toIndex > upperBound - lowerBound + 1
                    || fromIndex < 0 ) {
                throw new IndexOutOfBoundsException("Illegal index(-es). Out of bounds"
                        + (upperBound - lowerBound + 1));
            }
            return new ImmutableListView(lowerBound + fromIndex,
                    lowerBound + toIndex - 1);
        }

        @NotNull
        @Override
        public Object[] toArray() {
            Integer[] array = new Integer[upperBound-lowerBound+1];
            int j=0;
            for (int i = lowerBound; i <= upperBound; i++) {
                array[j++] = i;
            }
            return array;
        }

        @NotNull
        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(@NotNull T[] a) {
            Object[] array;
            int j=0;
            if (a.length < upperBound - lowerBound + 1) {
                array = (Object[]) Array.newInstance(
                        a.getClass().getComponentType(), upperBound - lowerBound + 1
                );
                for (int i = lowerBound; i <= upperBound; i++) {
                    array[j++] = i;
                }
            } else {
                array = (Object[]) Array.newInstance(
                        a.getClass().getComponentType(), upperBound - lowerBound +1
                );
                for (int i = lowerBound; i < a.length + lowerBound; i++) {
                    array[j++] = i;
                }
                for (int i = a.length + lowerBound; i <= upperBound; i++) {
                    array[j++] = null;
                }
            }
            return (T[]) array;
        }

        @Override
        public Integer get(int index) {
            if(index + lowerBound <= upperBound && index >= 0) {
                return index + lowerBound;
            }
            throw new IndexOutOfBoundsException("Current index "
                    + index + " is out of bound " + (upperBound - lowerBound));
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
