package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "registration_date")
    private LocalDate registration_date;

    public Student() {
    }

    public Student(String name, LocalDate registration_date) {
        this.name = name;
        this.registration_date = registration_date;
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

    public LocalDate getRegistration_date() {
        return this.registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    @Override
    public String toString() {
        return this.name + " " + this.registration_date;
    }
}

