/**
 * 
 */
package com.hany.java;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

/**
 * @author hany
 *
 */
public class WordReversalTest {
    
    final String originalString = "Dog bites man";
    
    
    
    
    
    @Test
    public void givenSentence_whenUsingStreamMethods_shouldReverseStringAsOutput()
    {
        StringTokenizer tokinizer = new StringTokenizer(originalString);
        Iterator<Object> itr = tokinizer.asIterator();
        ArrayList<String> reversed = new ArrayList();
        String strReversed = "";
        while(itr.hasNext())
        {
            String s = (String) itr.next();
            reversed.add(s);
        }
        
        for (int i = reversed.size()-1; i >= 0 ; i--)
        {
            String appender ="";
            if(i >0 )
                appender = " ";
            strReversed =strReversed +reversed.get(i)+appender ;
        }
        
        
//        System.out.println("Reversed String "+ strReversed+ "!");
        assertTrue("man bites Dog".equals(strReversed) );
    }

}
