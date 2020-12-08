package ru.mephi.java.part7.task01;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public class SieveOfErathostenes {
    private final Set<Integer> numsSet = new HashSet<>();
    private final BitSet primesBitSet = new BitSet();
    private final int n = 100;

    public SieveOfErathostenes() {
        fillCollections(n);
    }

    public SieveOfErathostenes(int n) {
        fillCollections(n);
    }

    private void fillCollections(int n) {
        for (int i = 2; i <= n; i++) {
            numsSet.add(i);
            primesBitSet.set(i);
        }
    }

    public Set<Integer> getPrimesHashSet() {
        for (int i = 2; i*i <= n; i++) {   // O(sqrt(n))
            for (int j = 2; j*i <= n; j++) {
                numsSet.remove(j*i);
            }
        }
        return numsSet;
    }

    public BitSet getPrimesBitSet() {
        for (int i = 2; i*i < n; i++) {
            if (primesBitSet.get(i)) {
                for (int j = i*i; j <= n; j += i) {
                    primesBitSet.clear(j);
                }
            }
        }
        return primesBitSet;
    }
}
