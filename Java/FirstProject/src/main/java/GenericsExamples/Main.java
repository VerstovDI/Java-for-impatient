package GenericsExamples;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public class Parent {
        private String name;

        public Parent(String name) {
            this.name = name;
        }

        public void parentMethod() {
            System.out.println("parent method");
        }
    }

    public class Child extends Parent {
        private String father;

        public Child(String name, String father) {
            super(name);
            this.father = father;
        }

        public void parentMethod() {
            System.out.println("child  method");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<Parent> lst = new ArrayList<>();
        main.doSomething(lst);
    }

    public void doSomething(List<? super Child> lst) {
        // какая-то логика

    }


}
