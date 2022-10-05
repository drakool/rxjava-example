package com.hany.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


public class ChallengeTests {
	
	
	/**
	 * @param source
	 * @return
	 */
	public static boolean sevenBoom( int [] source)
	{
	
		return Arrays.stream(source).boxed().anyMatch(elem -> elem.toString().contains("7"));
	}
	

	public static Integer[] toIntegerArray(int[] arr)
	{
		return Arrays.stream(arr).boxed().toArray(Integer[]::new);
	}
	
	public static List<String> sevenBoomSimple( int [] source)
	{
	return		Arrays.stream(source).boxed().map(elem->Integer.toString(elem))
							.collect(Collectors.toList());
	}
	
	
	@Test
	public void givenIntArray_WhenUsingStream_ShouldConvertToIntegerArray()
	{
		int[] originalArray = new int[] {1,2,3,4,5};
		Integer[] integerArray = toIntegerArray(originalArray);
		for(int i =0 ; i < integerArray.length;i++)
		{
			assertTrue(integerArray[i] ==Integer.valueOf(originalArray[i]));
		}
	}

	@Test
	public void givenIntArray_whenConvertedUsingLambda_ShouldReturnStringList(){
		List<String> returnList = ChallengeTests.sevenBoomSimple(new int[]{2, 6, 7, 9, 3});
		if(returnList.isEmpty() )
		return;
		
		List<String> referenceList = new ArrayList<>(List.of("2","6","7","9","3"));
		assertEquals(returnList.size(),referenceList.size());
	}
	@Test
	public void test1() {
		assertTrue( ChallengeTests.sevenBoom(new int[]{2, 6, 7, 9, 3}));
	}
	
	@Test
	public void test2() {
		assertFalse(ChallengeTests.sevenBoom(new int[]{33, 68, 400, 5}) );
	}
	
	@Test
	public void test3() {
		assertFalse( ChallengeTests.sevenBoom(new int[]{86, 48, 100, 66}));
	}
	
	@Test
	public void test4() {
		assertTrue( ChallengeTests.sevenBoom(new int[]{76, 55, 44, 32}));
	}
	
	@Test
	public void test5() {
		assertTrue( ChallengeTests.sevenBoom(new int[]{35, 4, 9, 37}));
	}
}
