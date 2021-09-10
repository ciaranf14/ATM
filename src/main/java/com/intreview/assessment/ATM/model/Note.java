package com.intreview.assessment.ATM.model;


public enum Note {
    FIVE(5), TEN(10), TWENTY(20), FIFTY(50);

    private final int value;

    Note(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}



