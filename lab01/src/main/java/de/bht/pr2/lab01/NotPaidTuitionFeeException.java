package de.bht.pr2.lab01;

public class NotPaidTuitionFeeException extends Exception {
    public NotPaidTuitionFeeException(String errorMessage){
        super (errorMessage);
    }
}
