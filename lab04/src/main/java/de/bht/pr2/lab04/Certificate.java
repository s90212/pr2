package de.bht.pr2.lab04;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Certificate implements Serializable {
    ArrayList<Grade> grades = new ArrayList<>();
    Student student;

    public Certificate(Student student) {
        this.student = student;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "grades=" + grades +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return Objects.equals(grades, that.grades) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grades, student);
    }
}
