package com.example.restcalculatorbyjosuehr.model;

public class Division extends Operation {

    /**
     * Parent constructor used
     * @param value1
     * @param value2
     */
    public Division(Double value1, Double value2) {
        super(value1, value2);
    }

    /**
     * calculates the division result using polymorphism
     * @return Double
     */
    @Override
    public Double calculate() {
        return this.value1 / this.value2;
    }
}
