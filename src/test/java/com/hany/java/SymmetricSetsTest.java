package com.hany.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.internal.Lists;
import org.assertj.core.util.Arrays;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SymmetricSetsTest {
    
    private final static Set<String> immutableSet1 = Set.of("Kotlin", "Java", "Rust", "Python", "C++");
    private final static Set<String> immutableSet2 = Set.of("Kotlin", "Java", "Rust", "Ruby", "C#");
    private final static Set<String> expectedOnlyInSet1 = Set.of("Python", "C++");
    private final static Set<String> expectedDiff = Set.of("Python", "C++", "Ruby", "C#");

    
    @BeforeEach
    public void setup()
    {
        
    }
    
    /**
     * Given two non symmetric sets when using stream filter should calculate symmetric difference set.
     */
    @Test
    public void givenTwoNonSymmetricSets_whenUsingStreamFilter_shouldCalculateSymmetricDifferenceSet()
    {
                
        Set <String> symmetricDifference = immutableSet1.stream().filter(elem -> immutableSet2.contains(elem))
                                                    .collect(Collectors.toSet());
        assertTrue(symmetricDifference.containsAll(Set.of("Kotlin", "Java", "Rust") ));
        
    }
    
    /**
     * Given two non symmetric sets when using stream filter should calculate set 1 minus set 2.
     */
    @Test
    public void givenTwoNonSymmetricSets_whenUsingStreamFilter_ShouldCalculateSet1MinusSet2()
    {
        Set <String> asymmetricDifference = immutableSet1.stream().filter(elem -> !immutableSet2.contains(elem))
        .collect(Collectors.toSet());
        assertTrue(asymmetricDifference.containsAll(expectedOnlyInSet1));
        
    }
    
    
    @Test
    public void givenTwoNonSymmetricSets_whenUsingStreamFilter_ShouldCalculateSet1UnionSet2MinusIntersection()
    {
        Set <String> unionSet = new HashSet<String>( immutableSet1);
        unionSet.addAll(immutableSet2);
        
        Set<String> asymmetricDifference = unionSet.stream().filter(elem->immutableSet1.contains(elem)&&immutableSet2.contains(elem)?false:true).collect(Collectors.toSet());
        
        System.out.println(asymmetricDifference.toString());
        assertTrue(asymmetricDifference.equals(expectedDiff));
        
    }
    /**
     * Given two non symmetric sets when using collection AP is should calculate symmetric difference set.
     */
    @Test
    public void givenTwoNonSymmetricSets_whenUsingCollectionAPIs_shouldCalculateSymmetricDifferenceSet()
    {
        Set <String> symmetricDifference = new HashSet<String>( immutableSet1);
        
        symmetricDifference.removeIf(elem-> !immutableSet2.contains(elem));
        
        assertTrue(symmetricDifference.containsAll(Set.of("Kotlin", "Java", "Rust") ));

    }
    
    
    /**
     * Given two sets when using stream filter should find the asymmetric difference set.
     */
    @Test
    public void givenTwoSets_whenUsingStreamFilter_shouldFindTheAsymmetricDifferenceSet()
    {
        Set<String> commonDifference = Sets.newHashSet(immutableSet2);
        
        assertThat(commonDifference).isEqualTo( Set.of("Kotlin", "Java", "Rust", "Ruby", "C#") );
        
        commonDifference.retainAll(immutableSet1);
        
        assertThat(commonDifference);
        
        assertTrue(commonDifference.containsAll(Set.of("Kotlin", "Java", "Rust")) );
        
        
    }    
    public static Set<String> symmetricDifference(final Set<String> setA,
    final Set<String> setB)
    {
        
        return setA.stream().filter(elem -> setB.contains(elem)).collect(Collectors.toSet());
        
    }
    
    @Test
    public void givenTwoSets_whenCallingFindDisjunction_shouldGetDisjunction() {
        Set<String> actualDiff = SymmetricSetsTest.findSymmetric(immutableSet1, immutableSet2);
        assertThat(actualDiff).isEqualTo(expectedDiff);
    }
    
    
    public static <T> Set<T> findSymmetric(Set<T> set1, Set<T> set2)
    {
        Map<T,Integer> map = new HashMap<>();
        set1.forEach(elem-> putKey(map, elem));
        set2.forEach(elem-> putKey(map, elem));
        
        
        return map.entrySet().stream().filter( e->e.getValue() ==1)
                .map(e->e.getKey())
                .collect(Collectors.toSet());
    }
    
    private static <T> void putKey(Map<T, Integer> map, T key) {
    
        if( map.containsKey(key))
        {
            map.replace(key, Integer.MAX_VALUE);
        }
        else {
            // intersection between two sets. 
            // Note that Set doesn't accept duplicates
            map.put(key,1);
        }
    }
    
    
}
