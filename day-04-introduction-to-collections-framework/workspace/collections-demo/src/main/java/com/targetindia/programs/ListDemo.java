package com.targetindia.programs;

import java.util.List;
import java.util.Vector;

public class ListDemo {

    public static void main(String[] args) {

        System.out.println(Thread.activeCount());


        List<Integer> numbers = new Vector<>();

        numbers.add(123);
        numbers.add(0, 200);
        numbers.add(300);

        System.out.println(numbers);
        System.out.println(numbers.get(1));
        numbers.set(1, 500);
        System.out.println(numbers);
        numbers.add(1, 999);
        System.out.println(numbers);

        for(var num: numbers){
            System.out.println(num);
        }

        var it = numbers.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
