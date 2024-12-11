package com.example.code;
import java.util.*;
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
		
		//use case of FI		
		taskManager();
		
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
	
	// A method to execute a task
    public static void executeTask(String taskType, Consumer<String> task, String taskData) {
        System.out.println("Executing " + taskType + " task...");
        task.accept(taskData);
    }
	
	
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
            if (taskData != null) executeTask(taskType, task, taskData);
        });
     
	}

}
