package com.example.restcalculatorbyjosuehr.model;

public abstract class Operation {
    protected Double value1;
    protected Double value2;

    /**
     * Abstract Constructor
     * @param value1 first value for the constructor
     * @param value2 second value for the constructor
     * */
    protected Operation(Double value1, Double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    /**
     * @return Double value1
     * */
    public Double getValue1() {
        return value1;
    }

    /**
     * @return Double value2
     * */
    public Double getValue2() {
        return value2;
    }
    /**
     * @return Double
     * */
    public abstract Double calculate();
}
