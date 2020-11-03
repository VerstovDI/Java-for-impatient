package ru.mephi.java.TheoryStaff.PECS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Slave slave1 = new Slave("managerField0",
                "employeeField0", "dig");
        Employee employee1 = new Employee("managerField1",
                "employeeField1");
        Employee employee2 = new Employee("managerField2",
                "employeeField2");
        Employee employee3 = new Employee("managerField3",
                "employeeField3");
        Manager manager = new Manager("managerFieldMain");
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        empList.add(slave1);
        // empList.add(manager); // нельзя
        printStaff(empList);
        ArrayList<? extends Employee> anotherEmpList = new ArrayList<>();
        // anotherEmpList.add(employee1); // так нельзя
        // anotherEmpList.add(slave1);
        /*
         because you cannot know at runtime which specific subtype of Employee the collection holds.
         ? - это любой из наследников. В рантайм не знаем, какой именно массив
         */
        //numberList is a producer of subtypes of numbers. Hence is generified with ? extends Number. Producer->Extends
        final List<? extends Number> numberList = DoubleStream.of(-99, 1, 2, 3, 4, 5, 6)
                .boxed().collect(Collectors.toList());
        //numberList.add(new Integer(1)); //Cannot add integer to this list, even though integer is a subtype of number.
        numberList.add(null);//Cannot add anything to numberList other than null
        final Number number = numberList.get(0);//Can only get values as Number type
        System.out.println(number.doubleValue());

        //integerList is a consumer of supertypes of integers. Hence is generified with ? super Integer. Consumer->Super
        final List<Object> doubleList = IntStream.of(99, 1, 2, 3, 4, 5, 6).boxed()
                .collect(Collectors.toList());
        final List<? super Integer> integerList = doubleList; //List<Object> can be assigned
        //integerList.add(new Object()); //Cannot add Object to the list, even though Object is a super type of Integer
        integerList.add(1);//Integers can be added
        //final Integer integer = integerList.get(0); //Cannot get values as Integer or Number
        final Object integer = integerList.get(0); //Can only get value in an  Object reference
        System.out.println(integer.toString());
    }

    public static void printStaff(ArrayList<? extends Employee> staff) {
        for (int i = 0; i < staff.size(); i++) {
            Employee e = staff.get(i);
            System.out.println(staff.get(i));
        }
    }
}
