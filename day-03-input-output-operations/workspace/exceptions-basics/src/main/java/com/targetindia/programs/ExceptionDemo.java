package com.targetindia.programs;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ExceptionDemo {

    public static void main(String[] args) {
        log.trace("start of main()");
        log.trace("you have supplied these arguments: " + Arrays.toString(args));

        if (args.length < 2) {
            log.error("two inputs required, but got {}", args.length);
            return;
        }

        var input1 = args[0];
        var input2 = args[1];
        var num = 0;
        var den = 0;

        try {
            num = Integer.parseInt(input1);
            den = Integer.parseInt(input2);
        } catch (NumberFormatException ex) {
            log.error("integer inputs were expected, but got {}", Arrays.toString(args));
            return;
        }

        if(den==0){
            log.error("cannot divide integer by zero");
            return;
        }

        var quot = num / den;
        var rem = num % den;

        log.info("dividing {} by {} results in {} as quotient and {} as remainder", num, den, quot, rem);

        log.trace("end of main()");
    }
}
