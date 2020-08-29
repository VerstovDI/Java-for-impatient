package ru.mephi.java.part4.task09;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

public class UniversalToString1 {
    private HashSet<Object> visitedObjectsSet = new HashSet<>();

    public String universalToString(Object object) {
        if (object == null) {
            return "null";
        }
        if (visitedObjectsSet.contains(object)) {
            return "...<cycle>...";
        }
        visitedObjectsSet.add(object);
        Class<?> cl = object.getClass();
        if (cl == String.class) {
            return (String) object;
        }
        if (cl.isArray()) {
            StringBuilder r = new StringBuilder(cl.getComponentType() + "[]{");
            for (int i = 0; i < Array.getLength(object); i++) {
                if (i > 0) {
                    r.append(",");
                }
                Object val = Array.get(object, i);
                if (cl.getComponentType().isPrimitive()) {
                    r.append(val);
                } else {
                    r.append(universalToString(val));
                }
            }
            return r + "}";
        }
        StringBuilder r = new StringBuilder(cl.getName());
        do {
            r.append("[");
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.toString().endsWith("[")) {
                        r.append(",");
                    }
                    r.append(f.getName());
                    r.append("=");
                    try {
                        Class<?> t = f.getType();
                        Object val = f.get(object);
                        if (t.isPrimitive()) {
                            r.append(val);
                        }
                        else {
                            r.append(universalToString(val));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r.append("]");
            cl = cl.getSuperclass();
            if (cl == Object.class) {
                return r.toString();
            }
            //visitedObjectsSet.remove(cl);
        } while (cl != null);
        return r.toString();
    }
}
