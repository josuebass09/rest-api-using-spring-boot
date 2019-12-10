package com.example.restcalculatorbyjosuehr.model;

public class Addition extends Operation{

    /**
     * Parent constructor used
     * @param value1
     * @param value2
     */
    public Addition(Double value1,Double value2)
    {
        super(value1,value2);
    }

    /**
     * calculates the addition result using polymorphism
     * @return Double
     */
    @Override
    public Double calculate() {
        return this.value1 + this.value2;
    }
}
