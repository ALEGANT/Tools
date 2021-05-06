package com.ggf.thread.tax;

public class TaxCalaculator {
    private final double salary;
    private final double bouns;
    private CalculatorStrategy strategy;

    public TaxCalaculator(double salary, double bouns) {
        this.salary = salary;
        this.bouns = bouns;
    }

    public void setStrategy(CalculatorStrategy strategy) {
        this.strategy = strategy;
    }

    protected double calcTax(){
        return strategy.calculate(getSalary(),getBouns());
    }

    protected double calcualte(){
        return calcTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBouns() {
        return bouns;
    }
}
