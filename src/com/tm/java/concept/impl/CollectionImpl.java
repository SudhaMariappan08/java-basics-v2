package com.tm.java.concept.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tm.java.concept.dto.Student;

public class CollectionImpl {

	public static void main(String[] args) {

		// List
		sortUsingList();

		// Set
		sortUsingSet();

		// Queue
		customPriorityOfQueue();

		// Map
		functionsOfMap();

		// TreeMapList
		mapImplementedForList();

		streamAndFlatteningString();

		dynamicMappingFunction("square");

	}

	/* 
	 * Adding items to list, printing using index, printing at specific position
	 * Sorting using collections
	 * */
	private static void sortUsingList() {
		System.out.println("\n--- List Output ---");
		
		List<String> languageList = new ArrayList<>();
		languageList.add("Java");
		languageList.add("Python");
		
		System.out.println("languageList initial: " + languageList);
		
		languageList.add(0, "php");
		languageList.add("Python");
		System.out.println("languageList after added in specific position: " + languageList);

		System.out.println("language at second position:" + languageList.get(1));

		Collections.sort(languageList);
		System.out.println("Sorted List: " + languageList);
	}

	/*
	 * Adding items in set, sorting set using treeSet, iterator for retreiving elemets
	 */
	private static void sortUsingSet() {

		System.out.println("\n--- Set Output ---");

		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(10);
		hashSet.add(20);
		hashSet.add(10); // Duplicate not added
		hashSet.add(30);

		System.out.println("HashSet: " + hashSet);

		Set<Integer> treeSet = new TreeSet<>(hashSet);
		System.out.println("TreeSet (sorted): " + treeSet);

		System.out.print("Iterating TreeSet: ");
		Iterator<Integer> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

	/*
	 * Queue implementation, customizing priority using comparator in priorityQueue
	 */
	private static void customPriorityOfQueue() {
		
		System.out.println("\n--- Queue Output ---");
		
		Queue<String> queue = new PriorityQueue<String>();
		queue.add("Task 2");
		queue.add("Task 1");
		queue.add("Task 3");
		// queue.add(null); // dont allow null values

		System.out.println("Queue: " + queue);

		PriorityQueue<Student> studentQueue = new PriorityQueue<>(Comparator.comparingInt(Student::getMarks));

		studentQueue.add(new Student("Deepak", 80));
		studentQueue.add(new Student("Mani", 81));
		studentQueue.add(new Student("Sindhu", 70));
		
		System.out.println("Student Output after sorted by Marks, default prioritys:" + studentQueue);

		System.out.println("Student Output after sorted by Marks, customized priority:");
		
		while (!studentQueue.isEmpty()) {
			System.out.println(studentQueue.poll());
		}
		
	}

	/* 
	 * HashMap Implemented, Tree Map for sorting items
	 */
	private static void functionsOfMap() {
		System.out.println("\n--- Map Example ---");
		Map<String, Integer> hashMap = new HashMap<>();
		// Hashmap not in a specified order.It can be in any order
		hashMap.put("One", 1);
		hashMap.put("Three", 3);
		hashMap.put("Three", 30);
		hashMap.put("Two", 2);

		System.out.println("HashMap: " + hashMap);

		// Obtain a value by key
		System.out.println("Value for key 'Two': " + hashMap.get("Two"));

		// Iterating over entries
		System.out.println("Iterating HashMap:");
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

		// TreeMap -> sort keys
		Map<String, Integer> treeMap = new TreeMap<>(hashMap);
		System.out.println("TreeMap: " + treeMap);
	}

	/*
	 * Behaviour of treeMap while having list as it's key
	 */
	private static void mapImplementedForList() {
		TreeMap<List<Integer>, String> treeMap = new TreeMap<>((list1, list2) -> {
			int minSize = Math.min(list1.size(), list2.size());
			for (int i = 0; i < minSize; i++) {
				int cmp = Integer.compare(list1.get(i), list2.get(i));
				if (cmp != 0)
					return cmp;
			}
			return Integer.compare(list1.size(), list2.size());
		});

		treeMap.put(Arrays.asList(1, 2, 3), "First");
		treeMap.put(Arrays.asList(1, 2), "Second");
		treeMap.put(Arrays.asList(2, 1), "Third");

		System.out.println("TreeMapList:" + treeMap);
	}

	/*
	 * Stream of string from map & List of String from flatMap
	 * Flattening objects implemented
	 */
	private static void streamAndFlatteningString() {

		List<String> sentences = Arrays.asList("Java is a programming language", "Collection is a framework in java");

		List<Stream<String>> mappedSentence = sentences.stream().map(sentence -> Arrays.stream(sentence.split(" ")))
				.collect(Collectors.toList());

		System.out.println("Using map");
		mappedSentence.forEach(stream -> stream.forEach(System.out::println));

		List<String> flatMappedSentence = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
				.collect(Collectors.toList());

		System.out.println("Using flatMap:" + flatMappedSentence);
	}

	/*
	 * Mapping multiple functions in a single method for dynamic method call
	 */
	private static void dynamicMappingFunction(String selectedMapper) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		Map<String, Function<Integer, Integer>> mappers = new HashMap<>();
		mappers.put("square", x -> x * x);
		mappers.put("double", x -> x * 2);
		mappers.put("increment", x -> x + 1);

		Function<Integer, Integer> mapper = mappers.get(selectedMapper);

		List<Integer> result = numbers.stream().map(mapper).toList();

		System.out.println("Mapped Numbers (" + selectedMapper + "): " + result);
	}

}
