package com.example.restcalculatorbyjosuehr.model;

public class Response {

    private String message;
    private String data;

    /**
     * @return String message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return String data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @param decimals Number of decimal for operation data output
     * @param result Double result
     */
    public void setDataFormat(int decimals, Double result)
    {
        this.data = String.format("%."+decimals+"f",result).replaceAll("[0,.]+$", "");
    }
}
