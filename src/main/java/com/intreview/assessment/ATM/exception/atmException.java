package com.intreview.assessment.ATM.exception;

public class atmException extends Exception {

    private boolean internalError;

    public atmException(String message) {
        this(message, false);
    }

    public atmException(String message, boolean isInternalError) {
        super(message);
        internalError = isInternalError;
    }

    public boolean isInternalError() {
        return internalError;
    }
}