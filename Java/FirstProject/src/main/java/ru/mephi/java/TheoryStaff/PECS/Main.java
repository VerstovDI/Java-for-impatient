package ru.mephi.java.TheoryStaff.PECS;

import java.util.ArrayList;

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
    }

    public static void printStaff(ArrayList<? extends Employee> staff) {
        for (int i = 0; i < staff.size(); i++) {
            Employee e = staff.get(i);
            System.out.println(staff.get(i));
        }
    }
}
