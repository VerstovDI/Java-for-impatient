package ru.mephi.java.part4.task09;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class UniversalToString2 {
    private HashMap<Object, ObjectInfo> visitedMap = new HashMap<>();
    private boolean firstCallFlag = true;

    private String toStringConversion(Object object, HashMap<Object, ObjectInfo> visitedMap) {
        if (object == null) {
            return "null";
        }
        Class<?> cl = object.getClass();
        if (cl == String.class) {
            return (String) object;
        }
        if (cl.isArray()) {
            StringBuilder r = new StringBuilder(cl.getComponentType() + "[]{");
            for (int i = 0; i < Array.getLength(object); i++) {
                if (i > 0) r.append(",");
                Object val = Array.get(object, i);
                if (cl.getComponentType().isPrimitive()) {
                    r.append(val);
                }
                else {
                    // ???
                    r.append(toStringConversion(object, visitedMap));
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
                        } else {
                            if (visitedMap.containsKey(val) && visitedMap.get(val).previousObject == null) {
                                r.append("<!cycle!>");
                            } else {
                                if (val != null) {
                                    if (visitedMap.containsKey(val)) {//
                                        r.append(visitedMap.get(val).stringDescription);//
                                        continue;//
                                    } else {//
                                        visitedMap.put(val, new ObjectInfo(object, ""));
                                    }//
                                }
                                r.append(toStringConversion(val, visitedMap));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r.append("]");
            cl = cl.getSuperclass();
            visitedMap.put(object, new ObjectInfo(object, r.toString()));
            if (cl == Object.class) {
                return r.toString();
            }
        } while (cl != null);
        return r.toString();
    }

    public String universalToString(Object object) {
        visitedMap.put(object, new ObjectInfo(null, "null"));
        return toStringConversion(object, visitedMap);
    }

    private static class ObjectInfo {
        private Object previousObject;
        private String stringDescription = "";

        public ObjectInfo() {
        }

        public ObjectInfo(Object previousObject, String stringDescription) {
            this.previousObject = previousObject;
            this.stringDescription = stringDescription;
        }
    }
}
