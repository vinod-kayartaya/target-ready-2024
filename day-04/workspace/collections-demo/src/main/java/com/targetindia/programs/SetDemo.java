package com.targetindia.programs;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {

        Collection<Integer> evens = new ArrayList<>();
        evens.add(10);
        evens.add(12);
        evens.add(12);
        evens.add(30);

        Set<Integer> nums = new HashSet<>();
        nums.add(100);
        nums.add(12);
        nums.add(222);
        nums.add(100);
        nums.add(123);
        nums.addAll(evens);

        System.out.println(evens);
        System.out.println(nums);

    }
}
