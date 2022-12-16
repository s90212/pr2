package de.bht.pr2.lab04;

import java.io.Serializable;
import java.util.Objects;

public class Subscription implements Serializable {
    Course course;
    Student student;

    public Subscription(Student student, Course course) {
        this.course = course;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "course=" + course +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(course, that.course) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, student);
    }
}
