package de.bht.pr2.lab01;

public class NotPaidTuitionFeeException extends Throwable {
    public NotPaidTuitionFeeException(String errorMessage) {
        super (errorMessage);
    }
}
