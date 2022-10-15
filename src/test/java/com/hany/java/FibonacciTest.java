/**
 * 
 */
package com.hany.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author hany
 *
 */
public class FibonacciTest {

    @Test
    public void givenFibNum_whenUsingdynamicProgramming_shouldReturnCorrectValue()
    {
        assertEquals(987,Fibonacci.calculate(16));
        
    }
}
