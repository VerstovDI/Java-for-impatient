package ru.mephi.java.part6.Extras.GenericArraysCreation.ClassClass;

import java.util.HashMap;
import java.util.Map;

public class Something {
    private final Map<Class<?>, Object> map = new HashMap<>();

    public <T> T get(Class<T> clazz) {
        return clazz.cast(map.get(clazz));
    }

    public <T> void put(Class<T> clazz, T favorite) {
        map.put(clazz, favorite);
    }
}
