package com.targetindia.programs;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class DivideIntegers {

    public static void main(String[] args) {
        log.trace("start of main()");
        log.trace("you have supplied these arguments: " + Arrays.toString(args));

        try{
            var input1 = args[0];
            var input2 = args[1];

            var num = Integer.parseInt(input1);
            var den = Integer.parseInt(input2);

            var quot = num/den;
            var rem = num%den;

            log.info("dividing {} by {} results in {} as quotient and {} as remainder", num, den, quot, rem);
        } catch(ArithmeticException ex){
            log.warn("Division by zero is not allowed for integers in Java.");
            return; // taking control outside of main() method; goes to `finally` before that
        } catch(ArrayIndexOutOfBoundsException ex){
            log.warn("two integers were required, but got {}", args.length);
            throw new RuntimeException("two integers were required, but got " + args.length); //; goes to `finally`
        } catch(NumberFormatException ex){
            log.warn("integer inputs were expected, but got {}", Arrays.toString(args));
            System.exit(1); // `finally` block is not executed here
        } finally {
            log.trace("doing some clean up activities in the `finally` block...");
        }

        log.trace("end of main()");
    }
}
