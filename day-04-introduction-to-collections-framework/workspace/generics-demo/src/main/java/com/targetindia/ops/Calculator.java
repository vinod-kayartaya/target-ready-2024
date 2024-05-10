package com.targetindia.ops;

public class Calculator<T> {

    private T first;
    private T second;

    public Calculator(T first, T second) {
        this.first = first;
        this.second = second;
    }

//    public int sum(){
//        return this.first + this.second;
//    }
}
