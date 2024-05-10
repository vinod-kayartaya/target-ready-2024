package com.targetindia.app;

import com.targetindia.service.ICalculatorService;

import java.util.ArrayList;
import java.util.List;

public class MathOps {
    // dependency
    private ICalculatorService calculatorService;

    public MathOps() {
    }

    // we can inject the dependency via this constructor
    public MathOps(ICalculatorService calculatorService) {
        System.out.println("MathOps constructor called");
        System.out.println("Got an object for type ICalculateService as " + calculatorService.getClass().getName());
        this.calculatorService = calculatorService;
    }

    // we can inject the dependency via this setter
    public void setCalculatorService(ICalculatorService calculatorService) {
        System.out.println("MathOps.setCalculatorService(..) called");
        System.out.println("Got an object for type ICalculateService as " + calculatorService.getClass().getName());
        this.calculatorService = calculatorService;
    }

    /**
     * This method is supposed calculate the sum, difference, product and dividend of `first` and `second`
     * numbers passed as arguments, square them, store them in a list and return the same
     *
     * @param first  input #1
     * @param second input #2
     * @return a list of 4 values (squares of sum, difference, product, dividend)
     */
    public List<Double> performMaths(double first, double second) {
        List<Double> list = new ArrayList<>();
        var x = calculatorService.add(first, second);
        list.add(x * x);
        x = calculatorService.subtract(first, second);
        list.add(x * x);
        x = calculatorService.multiply(first, second);
        list.add(x * x);
        x = calculatorService.divide(first, second);
        list.add(x * x);
        return list;
    }
}
