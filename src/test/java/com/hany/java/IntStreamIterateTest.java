/**
 * 
 */
package com.hany.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * @author hany
 *
 */
public class IntStreamIterateTest {

    
    private Widget [] widgets =  { new Widget(50, Widget.Color.RED) , new Widget (30, Widget.Color.BLUE),
            new Widget (5, Widget.Color.BLUE),new Widget (10, Widget.Color.GREEN)}    ;
    
    /**
     * Given object array when using stream filtering should iterate through the list of objects then return sum of fitlered objects.
     */
    @Test
    public void givenObjectArray_whenUsingStreamFiltering_shouldIterateThroughTheListOfObjects_thenReturnSumOfFitleredObjects() {

        IntStream intStream = IntStream.iterate(10, i -> i + 5)
                .limit(5);
        intStream.forEach(System.out::println);
        
        assertEquals (35,Arrays.stream(widgets).filter(w -> w.getColor()==Widget.Color.BLUE)
            .mapToInt(i -> i.getWeight()).reduce( 0, (num1, num2)-> num1+num2));
    }

    @Test
    public void iterate_thorugh() {
        
        Supplier<Integer> supplier;
        
//        IntStream.range(1, 6).
        
        IntStream.of(343, 434, 61, 1, 512,
                5234, 613434, 561);

    }

}