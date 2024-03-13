package com.targetindia.programs;

import java.util.List;
import java.util.stream.Stream;

public class StreamDemo1 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(120, 390, 48, 38, 120, 392, 48, 38, 22, 382, 572, 7772, 234);

        // first 5 of the numbers:
        nums.stream()
                .limit(5)
                .forEach(System.out::println); // .forEach(num -> System.out.println(num));

        System.out.println();
        nums.stream()
                .skip(5)
                .limit(3)
                .forEach(System.out::println); // .forEach(num -> System.out.println(num));

        System.out.println();
        nums.stream()
                .filter(num -> num % 2 == 1)
                .findFirst()
                .ifPresentOrElse(num -> System.out.println("first odd number is " + num), () -> System.out.println("No odd number found"));
    }

    public static void main2(String[] args) {
        List<String> names = List.of("vinod", "SHYAM", "Harish", "RAmesh", "Rohit");

//        names.stream()
//                .map(name -> name.toUpperCase())
//                .forEach(name -> System.out.println(name));

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public static void main1(String[] args) {
        Stream<Integer> numbers = Stream.of(120, 39, 48, 38, 120, 39, 48, 38, 22, 382, 57, 777, 234);

        numbers
                .filter(num -> num % 2 == 0)
                .distinct()
                .sorted()
                .forEach(num -> System.out.println(num));


    }
}
