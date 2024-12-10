package com.example.code;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExampleStream {

	public static void main(String args[]) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		filter(numbers);
		
		reduce(numbers);
		
		collect(numbers);
		
		forEach(numbers);
	}
	
	public static void filter(List<Integer> numbers) {
		
		// filtering numbers less than 3
		List<Integer> filterNumbers = numbers.stream().filter(n -> n<3)
				.collect(Collectors.toList());
		System.out.println(filterNumbers);
	}
	
	public static void reduce(List<Integer> numbers) {
		
		Optional<Integer> output = numbers.stream().reduce(Integer::sum);
		System.out.println(output);
		
	} 
	
	public static void collect(List<Integer> numbers) {
		 List<Integer> doubleNumbers = numbers.stream()
                 .map(num -> num + num)
                 .collect(Collectors.toList());
		 System.out.println("Doubled the input Numbers: " + doubleNumbers);
	}

	public static void forEach(List<Integer> numbers) {
		numbers.forEach(System.out::println);
    }
}
