package com.targetindia.tests;

import com.targetindia.app.MathOps;
import com.targetindia.service.ICalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MathOps_PerformMaths_Tests {

    @Mock // mockito will create a dummy implementation for this interface (which is called a mock object)
    ICalculatorService calculatorService;

    @InjectMocks // Mockito will inject the above variable into this object via setter
    MathOps ops;

    // @BeforeEach
    void setup() {
        Mockito.when(calculatorService.add(10, 5)).thenReturn(15.0);
        Mockito.when(calculatorService.subtract(10, 5)).thenReturn(5.0);
        Mockito.when(calculatorService.multiply(10, 5)).thenReturn(50.0);
        Mockito.when(calculatorService.divide(10, 5)).thenReturn(2.0);
    }

    // @Test
    void shouldPerformMaths() {
        var list = ops.performMaths(10, 5); // 15^2, 5^2, 50^, 2^2 // i.e, 225, 25, 2500, 4
        Assertions.assertEquals(225, list.get(0));
        Assertions.assertEquals(25, list.get(1));
        Assertions.assertEquals(2500, list.get(2));
        Assertions.assertEquals(4, list.get(3));
    }

    @ParameterizedTest
    @CsvFileSource(files = {"input-source1.csv"})
    void shouldPerformMathsOnMultipleInputs(
            double input1, double input2,
            double return1, double return2, double return3, double return4,
            double expected1, double expected2, double expected3, double expected4
    ){
        Mockito.when(calculatorService.add(input1, input2)).thenReturn(return1);
        Mockito.when(calculatorService.subtract(input1, input2)).thenReturn(return2);
        Mockito.when(calculatorService.multiply(input1, input2)).thenReturn(return3);
        Mockito.when(calculatorService.divide(input1, input2)).thenReturn(return4);

        var list = ops.performMaths(input1, input2); // 15^2, 5^2, 50^, 2^2 // i.e, 225, 25, 2500, 4
        Assertions.assertEquals(expected1, list.get(0));
        Assertions.assertEquals(expected2, list.get(1));
        Assertions.assertEquals(expected3, list.get(2));
        Assertions.assertEquals(expected4, list.get(3));
    }

}
