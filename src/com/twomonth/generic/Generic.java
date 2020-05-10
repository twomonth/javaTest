package com.twomonth.generic;

public class Generic <T> {
    private T parameter;

    public Generic(T parameter) {
        this.parameter = parameter;
    }

    public T getParameter() {
        return parameter;
    }

    public void setParameter(T parameter) {
        this.parameter = parameter;
    }
}
