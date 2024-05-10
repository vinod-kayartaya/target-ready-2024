package com.targetindia.programs;

import com.targetindia.app.MathOps;

public class Main {

    public static void main(String[] args) {
        MathOps op = new MathOps();

        var list = op.performMaths(1.2, 3.4);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
    }
}
