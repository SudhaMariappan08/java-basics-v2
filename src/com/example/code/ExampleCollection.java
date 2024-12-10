package com.example.code;
import java.util.*;

import com.example.code.dto.Student;

public class ExampleCollection {

	

	    public static void main(String[] args) {
	        
	    	// List
	    	exampleList();
	    	
	        // Set
	    	exampleSet();

	        // Queue
	    	exampleQueue();
	    	
	    	// Map
	    	exampleMap();
	    	
	    	//TreeMapList
	    	exampleTreeMapList();
	       
	    }
	    
	    private static void exampleList() {
	    	System.out.println("\n--- List Output ---");
	    	List<String> languageList = new ArrayList<>();
	    	languageList.add("Java");
	    	languageList.add("Python");
	    	System.out.println("languageList initial: " + languageList);
	    	languageList.add(0, "php");
	    	languageList.add("Python"); // Duplicate can be added
	    	
	    	System.out.println("languageList after added in specific position: " + languageList);
	    	
	    	System.out.println("language at second position:" + languageList.get(1));
	    	
	    	Collections.sort(languageList);
	        System.out.println("Sorted List: " + languageList);
	    }

	    private static void exampleSet() {
	    	
	        System.out.println("\n--- Set Output ---");
	        Set<Integer> hashSet = new HashSet<>();
	        hashSet.add(10);
	        hashSet.add(20);
	        hashSet.add(10); // Duplicate not added
	        hashSet.add(30);

	        System.out.println("HashSet: " + hashSet);

	        //TreeSet -- for sorted set
	        Set<Integer> treeSet = new TreeSet<>(hashSet);
	        System.out.println("TreeSet (sorted): " + treeSet);

	        // Iterating using Iterator
	        System.out.print("Iterating TreeSet: ");
	        Iterator<Integer> iterator = treeSet.iterator();
	        while (iterator.hasNext()) {
	            System.out.print(iterator.next() + " ");
	        }
	        System.out.println();
	    }

	    private static void exampleQueue() {
	        System.out.println("\n--- Queue Output ---");
	        Queue<String> queue = new PriorityQueue<String>();
	        queue.add("Task 2");
	        queue.add("Task 1");
	        queue.add("Task 3");
	        //queue.add(null); // dont allow null values

	        System.out.println("Queue: " + queue);
	     
	        // PriorityQueue with custom comparator
	        PriorityQueue<Student> studentQueue = new PriorityQueue<>(Comparator.comparingInt(Student::getMarks));
	        
	        studentQueue.add(new Student("Deepak", 80));
	        studentQueue.add(new Student("Mani", 81));
	        studentQueue.add(new Student("Sindhu", 70));
	        
	        System.out.println("Student Output after sorted by Marks:" + studentQueue);
	       
	    }

	    private static void exampleMap() {
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


	    public static void exampleTreeMapList() {
	            TreeMap<List<Integer>, String> treeMap = new TreeMap<>(
	                (list1, list2) -> {
	                    int minSize = Math.min(list1.size(), list2.size());
	                    for (int i = 0; i < minSize; i++) {
	                        int cmp = Integer.compare(list1.get(i), list2.get(i));
	                        if (cmp != 0) return cmp; 
	                    }
	                    return Integer.compare(list1.size(), list2.size()); 
	                }
	            );

	            treeMap.put(Arrays.asList(1, 2, 3), "First");
	            treeMap.put(Arrays.asList(1, 2), "Second");
	            treeMap.put(Arrays.asList(2, 1), "Third");

	            System.out.println("TreeMapList:" +treeMap);
	    }


	    
}
