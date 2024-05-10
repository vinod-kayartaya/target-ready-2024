package com.targetindia.programs;

import com.targetindia.ops.Calculator;

public class CalculateSum {

    public static void main(String[] args) {
        Calculator<Integer> c1 = new Calculator<>(100, 200);
//        int sum = c1.sum();
//        System.out.println("sum is " + sum);

        Double n1 = 100.;
        Calculator<Double> c2 = new Calculator<>(100.0, 200.0);
//        double total = c2.sum();
//        System.out.println("total is " + total);

        Calculator<String> c3 = new Calculator<>("Vinod", "Kumar");
    }
}
