package ru.mephi.java.part6.task03;

public class Main {
    public static void main(String[] args) {
        Table<Integer, String> stringTable = new Table<>();
        stringTable.add(new Entry<>(1, "Aidarche"));
        stringTable.add(new Entry<>(2, "Danila"));
        stringTable.add(new Entry<>(3, "Kirill"));
        stringTable.add(new Entry<>(4, "Sasha"));
        stringTable.add(new Entry<>(5, "Vanya"));
        stringTable.add(new Entry<>(6, "Karpen"));
        stringTable.add(new Entry<>(7, "Pokek"));
        stringTable.add(new Entry<>(8, "Vasilina"));
        System.out.println(stringTable);
        System.out.println(stringTable.get(1));
        System.out.println(stringTable.get(8));
        //System.out.println(stringTable.get(9));
        stringTable.set(7, "Kopek");
        System.out.println(stringTable.get(7));
        stringTable.remove(2);
        System.out.println(stringTable);
    }
}
