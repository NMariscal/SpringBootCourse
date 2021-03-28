package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


// Map a student to a table in a data base
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator( name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1
    )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "student_sequence")
// end of mapping a student to a data base

    private Long id;
    private String name;
    private LocalDate dob;
    private String email;

    // No tiene por qué ser una columna de nuestra table (eliminar de los constructores)
    @Transient
    private Integer age;

    public Student(Long id, String name,  LocalDate dob, String email) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.id = id;
    }

    public Student() {
    }

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
