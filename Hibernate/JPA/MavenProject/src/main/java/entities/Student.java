package entities;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate registeredOn;

    public Student() {
    }

    public Student(String name, LocalDate registeredOn) {
        this.name = name;
        this.registeredOn = registeredOn;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegisteredOn() {
        return this.registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

}
