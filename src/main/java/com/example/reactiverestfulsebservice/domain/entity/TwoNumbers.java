package com.example.reactiverestfulsebservice.domain.entity;

public class TwoNumbers {

    private int a;
    private int b;

    public TwoNumbers(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public TwoNumbers() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "TwoNumbers{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
