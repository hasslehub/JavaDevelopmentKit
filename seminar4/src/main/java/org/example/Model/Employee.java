package org.example.Model;

public class Employee {

    static int COUNT = 0;
    protected long ID;
    private String phoneNumber;
    private String name;
    private int seniority;

    public Employee(String phoneNumber, String name, int seniority) {
        this.ID = ++COUNT;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.seniority = seniority;
    }

    public long getId() {
        return ID;
    }

    public void setId(long id) {
        this.ID = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "Сотрудник " +
                "\tID = " + ID + "\t" +
                "\tНомер телефона = " + phoneNumber + "\t" +
                "\tИмя = " + name + "\t" +
                "\tСтаж = " + seniority;
    }
}