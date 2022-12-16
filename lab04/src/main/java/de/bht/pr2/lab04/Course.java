package de.bht.pr2.lab04;

import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable {
    String name;
    String studyCourse;

    public Course(String name, String studyCourse) {
        this.name = name;
        this.studyCourse = studyCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", studyCourse='" + studyCourse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) && Objects.equals(studyCourse, course.studyCourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studyCourse);
    }
}
