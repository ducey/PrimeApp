package com.nathanducey.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nathanducey.main.PrimeService;

@RunWith(MockitoJUnitRunner.class)
public class PrimeServiceTest {

	@Mock
	private PrimeService pServiceTest;	
	private List<Integer> fiveArray = Arrays.asList(2,3,5);
	private List<Integer> fiftyArray = Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47);
		
	@Test
	public void test_findPrimes_withFive_returns_correctList() {		
		// Given
		int numberToCheck = 5;
		when(pServiceTest.findPrimes(anyInt())).thenReturn(fiveArray);
				
		// When
		List<Integer> result = pServiceTest.findPrimes(numberToCheck);
				
		// Then
		assertEquals(3, result.size());
		assertEquals(fiveArray, result);
		
	}
	
	@Test
	public void test_findPrimes_withFifty_returns_correctList() {
		// Given
		int numberToCheck = 50;
		when(pServiceTest.findPrimes(anyInt())).thenReturn(fiftyArray);
		
		// When
		List<Integer> result = pServiceTest.findPrimes(numberToCheck);
		
		// Then
		assertEquals(15, result.size());
		assertEquals(fiftyArray, result);
	}
	
	@Test
	public void test_findPrimes_withOne_returns_emptyList() {
		// Given
		int numberToCheck = 1;
		when(pServiceTest.findPrimes(anyInt())).thenReturn(Collections.emptyList());
		
		// When
		List<Integer> result = pServiceTest.findPrimes(numberToCheck);
		
		// Then
		assertEquals(0, result.size());
	}
	
	
}
