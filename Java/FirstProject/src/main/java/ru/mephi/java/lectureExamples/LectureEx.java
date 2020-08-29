package ru.mephi.java.lectureExamples;
import java.util.*;

public class LectureEx {
    public static class Person {
        public String firstName;
        public String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }
    }
    public static void main(String[] args) {
        Person[] people = { new Person("Boba", "Ann"), new Person("Pan", "Peter"),
                new Person("Dostoevskaya", "Anna") };
        Arrays.sort(people, Comparator.comparing(Person::getLastName, (s, t) ->
                s.length() - t.length()));

        Arrays.sort(people, Comparator.comparingInt(p -> p.getLastName().length()));
    }
}
