package ru.mephi.java.part6.task04;

public class Main {
    public static void main(String[] args) {
        Table<Integer, String> table = new Table<>();
        table.add(1, "Aidarche");
        table.add(2, "Danila");
        table.add(3, "Kirill");
        table.add(4, "Sasha");
        table.add(5, "Vanya");
        table.add(6, "Karpen");
        table.add(7, "Pokek");
        // TODO: task 3 & task 4 -> вынести тестирование в отдельный метод, убрать дубликаты
        table.add(8, "Vasilina");
        System.out.println(table);
        System.out.println(table.get(1));
        System.out.println(table.get(8));
        //System.out.println(table.get(9));
        table.set(7, "Kopek");
        System.out.println(table.get(7));
        table.remove(2);
        System.out.println(table);
    }
}
