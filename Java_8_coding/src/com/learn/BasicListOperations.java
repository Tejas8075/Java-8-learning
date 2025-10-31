package com.learn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicListOperations {

	public static void main(String[] args) {

//		 Print the list using Lambda Expressions
		List<String> l1 = List.of("Alice", "Bob", "Charlie");
		l1.stream()
		  .forEach(System.out::println);

//		Filter even numbers from a List using Streams
		List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5, 6);
		l2.stream()
		  .filter(nums -> nums % 2 == 0)
		  .forEach(System.out::println);
		
//		Find the maximum value in the List using Streams
		List<Integer> l3 = List.of(10, 20, 30, 40, 50);
		Integer res1 = l3.stream()
		  .max(Integer::compare)
		  .orElse(0);
		System.out.println(res1);
		
//		Convert the List of Strings to UpperCase
		List<String> l4 = List.of("alice", "bob", "charlie");
		l4.stream()
		  .map(String::toUpperCase)
		  .collect(Collectors.toList())
		  .forEach(System.out::println);
		
//		Group strings by their length using  groupingBy()
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie"); 
		Map<Integer, List<String>> res2 = names.stream()
		     .collect(Collectors.groupingBy(String::length));
		System.out.println(res2);
		
//		Find the sum of numbers using  reduce()
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		Integer res3 = numbers.stream()
							  .reduce(0, Integer::sum);
		System.out.println(res3);
		
//		Count word occurrences in a list using groupingBy()
		List<String> words = Arrays.asList("apple", "banana", "apple");
		Map<String, Long> res4 = words.stream()
										 .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
		System.out.println(res4);
		
//		Concatenate strings using joining()
		List<String> newWords = Arrays.asList("Java", "is", "awesome"); 
		String res5 = newWords.stream()
							  .collect(Collectors.joining(" "));
		System.out.println(res5);
		
//		Sort employees by salary
		class Employee {
			String name;
			int salary;

			Employee(String name, int salary) {
				this.name = name;
				this.salary = salary;
			}

			public String toString() {
				return name + ": " + salary;
			}
		}
		List<Employee> employees = Arrays.asList(new Employee("Alice", 5000), 
												 new Employee("Bob", 3000),
												 new Employee("Charlie", 4000)
												);
		
		List<Employee> sortedEmps = employees.stream()
											 .sorted(Comparator.comparing(e -> -e.salary))
											 .toList();
		System.out.println(sortedEmps);
		
//		******Find the first non-repeated character in a string.****
		String input = "swiss";
		char[] charArr = input.toCharArray();
//		String res5 = 
		
//		Use  Stream.distinct() to remove duplicates from  a list.
		List<Integer> dupNumbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5); 
		List<Integer> res6 = dupNumbers.stream()
									   .distinct()
									   .toList();
		System.out.println(res6);
		
//		Find all elements starting with "A" in a list
		List<String> startNames = Arrays.asList("Alice", "Bob", "Annie", "Alex"); 
		List<String> res7 = startNames.stream()
									  .filter(n -> n.startsWith("A"))
									  .toList();
		System.out.println(res7);
		
//		Sort a list of strings alphabetically and in reverse order
		List<String> sortNames = Arrays.asList("Charlie", "Alice", "Bob");
		List<String> res8 = sortNames.stream()
									 .sorted() // Ascending
									 .sorted(Comparator.reverseOrder())
									 .toList();
		System.out.println(res8);
		
//		Flatten a list of lists using  flatMap()
		List<List<Integer>> nestedList = Arrays.asList( 
				Arrays.asList(1, 2, 3), 
				Arrays.asList(4, 5), 
				Arrays.asList(6, 7, 8) 
				); 
		List<Integer> res9 = nestedList.stream()
									   .flatMap(List::stream)
									   .toList();
		System.out.println(res9);
		
//		Use  Collectors.partitioningBy() to separate even and odd numbers
		List<Integer> partNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Boolean, List<Integer>> res10 = partNumbers.stream()
													   .collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println(res10);
		
//		Find the second highest number in a list.
		List<Integer> secHighNumber = Arrays.asList(10, 20, 50, 40, 50); 
		Integer res11 = secHighNumber.stream()
									 .distinct()
									 .sorted(Comparator.reverseOrder())
									 .skip(1)
									 .findFirst()
									 .orElseThrow(() -> new RuntimeException("No second highest found"));
		
		System.out.println(res11);
		
		
	}

}
