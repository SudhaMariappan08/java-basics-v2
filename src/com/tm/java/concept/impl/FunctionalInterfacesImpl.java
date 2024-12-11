package com.tm.java.concept.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesImpl {

	public static void main(String args[]) {

		doFunctionBasedOnPriority();

		eventHandling();

		taskManager();
	}

	/*
	 * FunctionalInterface methods such as apply,compose, andThen,identity implemented
	 */
	private static void doFunctionBasedOnPriority() {

		Function<Integer, Integer> doubleFunction = x -> x * 2;
        Function<Integer, Integer> squareFunction = x -> x * x;

        // Using apply
        System.out.println("Apply doubleFunction to 5: " + doubleFunction.apply(5)); 

        // Using andThen: Double first, then square
        Function<Integer, Integer> doubleThenSquare = doubleFunction.andThen(squareFunction);
        System.out.println("Double then square 3: " + doubleThenSquare.apply(3)); 

        // Using compose: Square first, then double
        Function<Integer, Integer> squareThenDouble = doubleFunction.compose(squareFunction);
        System.out.println("Square then double 3: " + squareThenDouble.apply(3));
        
        // Using identity: No transformation method
        Function<Integer, Integer> num = Function.identity();
		System.out.println("Identity display:" + num.apply(3));

	}
	
	/*
	 * Generate a randomNumber using supplier and check condition with predicate and
	 * consume the message in case of successful operation
	 */
	private static void eventHandling() {
        Consumer<String> printMessage = message -> System.out.println(message);

        // Supplier: Provide a random value between 0-99
        Supplier<Integer> randomNumber = () -> new Random().nextInt(100);
        
        Predicate<Integer> isEven = x -> x % 2 == 0;
        
        List<Integer> numbers = List.of(randomNumber.get());
        System.out.println("Processing list of numbers:");
        numbers.stream()
                .filter(isEven)
                .forEach(num -> printMessage.accept("Even number: " + num));
	}

	// A method to execute the task
	private static void executeTask(String taskType, Consumer<String> task, String taskData) {
		System.out.println("Executing " + taskType + " task...");
		task.accept(taskData);
	}

	/*
	 * Method implemented with multiple task behaviour and task to do with a single
	 * method call(executeTask)
	 */
	private static void taskManager() {

		// Define task behaviors using lambdas
		Consumer<String> emailTask = email -> System.out.println("Sending email to: " + email);
		Consumer<String> fileProcessingTask = fileName -> System.out.println("Processing file: " + fileName);
		Consumer<String> dbCleanupTask = dbName -> System.out.println("Cleaning up database: " + dbName);

		// Register tasks in a task manager (Map)
		Map<String, Consumer<String>> taskManager = new HashMap<>();
		taskManager.put("Email", emailTask);
		taskManager.put("FileProcessing", fileProcessingTask);
		taskManager.put("DatabaseCleanup", dbCleanupTask);

		// Task data
		String email = "user@example.com";
		String file = "document.txt";
		String database = "user_db";

		// Execute tasks dynamically
		taskManager.forEach((taskType, task) -> {
			String taskData = switch (taskType) {
			case "Email" -> email;
			case "FileProcessing" -> file;
			case "DatabaseCleanup" -> database;
			default -> null;
			};
			if (taskData != null)
				executeTask(taskType, task, taskData);
		});

	}

}
