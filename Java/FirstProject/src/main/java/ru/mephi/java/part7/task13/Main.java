package ru.mephi.java.part7.task13;

public class Main {
    public static void main(String[] args) {
        Cache<String, String> cache = new Cache<>(5);
        cache.put("Beryozkin", "Coding theory");
        cache.put("Drevs", "Philosophy");
        cache.put("Androsov", "Java");
        cache.put("Ella", "OS");
        cache.put("Krasnikova", "da");
        System.out.println(cache.entrySet());
        cache.put("Kuluk", "net");
        System.out.println(cache.entrySet());
    }
}
