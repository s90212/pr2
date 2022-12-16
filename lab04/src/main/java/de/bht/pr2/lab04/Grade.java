package de.bht.pr2.lab04;

import java.io.Serializable;
import java.util.Objects;

public class Grade implements Serializable {
    Double grade;
    Subscription subscription;

    public Grade(Subscription subscription, Double grade) {
        this.grade = grade;
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade=" + grade +
                ", subscription=" + subscription +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return Objects.equals(grade, grade1.grade) && Objects.equals(subscription, grade1.subscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, subscription);
    }
}
