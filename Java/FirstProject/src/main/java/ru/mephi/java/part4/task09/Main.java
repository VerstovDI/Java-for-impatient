package ru.mephi.java.part4.task09;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        System.out.println(universalToString(new Class1()));
    }

    public static String universalToString(Object object) {
        StringBuilder sb = new StringBuilder();
        Class<?> cl = object.getClass();
        for (Field field : cl.getDeclaredFields()) {  /// посмотреть с полями родителя
            field.setAccessible(true);
            sb.append("::");
            sb.append(field.getType().getSimpleName());
            sb.append(" ");
            sb.append(field.getName());  /// если у Point не перегружен.? // запоминать экз. класса, в которых я уже был. Потворно не обрабатывать
            sb.append(" = ");           // HashSet
            try {
                sb.append(field.get(object));
            } catch (IllegalAccessException e) {
                System.out.println("can't get access");
            }
        }
        return  sb.toString();
    }
}
