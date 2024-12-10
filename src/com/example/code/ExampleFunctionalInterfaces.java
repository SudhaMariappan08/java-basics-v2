package com.example.code;
import java.util.function.*;

public class ExampleFunctionalInterfaces {

	public static void main(String args[]) {
		
		functionApply();
				
		functionAndThen();
		
		functionCompose();
		
		functionIdentity();
		
		predicate();
		
		consumer();
		
		supplier();
		
	}
	
	private static void functionApply() {
		
		Function<Integer, Double> num = a -> a/2.0;
		System.out.println(num.apply(20));
		
	}
	
	private static void functionCompose() {
		Function<Integer, Double> num = a -> a/2.0;
		
		num = num.compose(a-> a + 1);
		System.out.println(num.apply(20));
		
	}
	
	private static void functionIdentity() {
		Function<Integer, Integer> num = Function.identity();
		System.out.println(num.apply(20));
	}
	
	private static void functionAndThen() {
		Function<Integer, Double> num = a -> a/2.0;
		
		num = num.andThen(a-> a + 1);
		System.out.println(num.apply(20));
	}
	
	private static void predicate() {
		Predicate<String> emptyCheck = str -> str.isEmpty();
		System.out.println(emptyCheck.test("Exists"));  // return a boolean
	}
	
	private static void consumer() {
		Consumer<String> consumeText = str -> System.out.println(str.length());
		consumeText.accept("Consumer");  // return appended string
	}
	
	private static void supplier() {
		Supplier<String> supplyText = () -> "Hello Supplier";
		System.out.print(supplyText.get());
	}
}
