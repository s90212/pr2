package de.bht.pr2.lab04;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    String name;
    int registrationNumber;
    Course course;

    public Student(String name, int registrationNumber, Course course) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.course = course;
    }
    public Student(String name, int registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", registrationNumber=" + registrationNumber +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return registrationNumber == student.registrationNumber && Objects.equals(name, student.name) && Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, registrationNumber, course);
    }
}
