package ru.mephi.java.part6.TheoryStaff.PECS;

public class Slave extends Employee {
    protected String purpose;

    public Slave(String someManagerField, String someEmployeeField, String purpose) {
        super(someManagerField, someEmployeeField);
        this.purpose = purpose;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "Slave{" +
                "purpose='" + purpose + '\'' +
                '}';
    }
}
