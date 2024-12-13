package com.tm.java.concept.collections.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamImpl {

	public static void main(String args[]) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		multiFunctionInSingleList(numbers);
		
	}

	/*
	 * Performing multiple operations for an integer List and converting it to new list
	 */
	private static void multiFunctionInSingleList(List<Integer> numbers) {

        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Filtered Even Numbers: " + evenNumbers);

        int sumOfEvenNumbers = evenNumbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum of Even Numbers: " + sumOfEvenNumbers);

        System.out.println("Even Numbers (Printed with forEach):");
        evenNumbers.forEach(num -> System.out.println(num));

	}

}
