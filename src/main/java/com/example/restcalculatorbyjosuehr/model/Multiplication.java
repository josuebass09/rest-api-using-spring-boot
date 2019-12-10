package com.example.restcalculatorbyjosuehr.model;

public class Multiplication extends Operation {

    /**
     * Parent constructor used
     * @param value1
     * @param value2
     */
    public Multiplication(Double value1, Double value2) {
        super(value1, value2);
    }

    /**
     * calculates the multiplication result using polymorphism
     * @return Double
     */
    @Override
    public Double calculate()
    {
        return this.value1 * this.value2;
    }
}
