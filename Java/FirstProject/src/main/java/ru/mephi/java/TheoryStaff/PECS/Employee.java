package ru.mephi.java.TheoryStaff.PECS;

public class Employee extends Manager {
    private String someEmployeeField;

    public Employee(String someManagerField, String someEmployeeField) {
        super(someManagerField);
        this.someEmployeeField = someEmployeeField;
    }

    public String getSomeEmployeeField() {
        return someEmployeeField;
    }

    public void setSomeEmployeeField(String someEmployeeField) {
        this.someEmployeeField = someEmployeeField;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "someEmployeeField='" + someEmployeeField + '\'' +
                '}';
    }
}
