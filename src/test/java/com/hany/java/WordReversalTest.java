/**
 * 
 */
package com.hany.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * @author hany
 *
 */
public class WordReversalTest {

    final String originalString = "Dog bites man";

    
//    @SuppressWarnings("unchecked")
//    static <T> Stream<T> reverse(Stream<T> input) {
//        Object[] temp = input.toArray();
//        return (Stream<T>) IntStream.range(0, temp.length)
//                                    .mapToObj(i -> temp[temp.length - i - 1]);
//    }
    
    @Test
    public void givenSentence_whenUsingCollections_shouldReverseStringAsOutput() {
        StringTokenizer tokenizer = new StringTokenizer(originalString);

//        Collections.list(tokenizer).stream().map(i -> (tokenizer.countTokens()-1) - i + 0 - 1);
        ArrayDeque<String> dequeue = new ArrayDeque<String>() ;
        while(tokenizer.hasMoreTokens())
        {
            dequeue.add(tokenizer.nextToken());
        }
        
        
//        assertTrue("man bites Dog".equals( dequeue.stream().reduce(" "  ,ArrayDeque<String>::getFirst)) );

    }
    @Test
    public void givenSentence_whenUsingStream_shouldReverseStringAsOutput() {
        StringTokenizer tokenizer = new StringTokenizer(originalString);

        int totalTokens = tokenizer.countTokens();
        String[] word = new String[totalTokens];

        // setup for loop
        for (int y = totalTokens - 1; y >= 0; y--) {
            word[y] = tokenizer.nextToken();
        }
        
        Stream<String> reversed = Stream.of(word);
        
//        reversed.iterator()reversed.
        
        
        //        System.out.println("Reversed String "+ strReversed+ "!");
//        assertTrue("man bites Dog".equals(word.toString()));
    }

    /**
     * Given sentence when using iterator should reverse string as output.
     */
    @Test
    public void givenSentence_whenUsingIterator_shouldReverseStringAsOutput() {
        StringTokenizer tokinizer = new StringTokenizer(originalString);
        Iterator<Object> itr = tokinizer.asIterator();
        ArrayList<String> reversed = new ArrayList();
        String strReversed = "";
        while (itr.hasNext()) {
            String s = (String) itr.next();
            reversed.add(s);
        }

        for (int i = reversed.size() - 1; i >= 0; i--) {
            String appender = "";
            if (i > 0)
                appender = " ";
            strReversed = strReversed + reversed.get(i) + appender;
        }

//        System.out.println("Reversed String "+ strReversed+ "!");
        assertTrue("man bites Dog".equals(strReversed));
    }

}
