package com.learn.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BasicLevelQuestions {

	public static void main(String[] args) {

//		1)
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		allEvenNums(list);

//		2)
		List<String> names = Arrays.asList("java", "stream", "api");
		stringdToUpperCase(names);

//		3)
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		sumOfNums(nums);

//		4)
		List<Integer> maxNum = Arrays.asList(3, 7, 2, 9, 5);
		maxNumInList(maxNum);

//		5)
		List<Integer> minNums = Arrays.asList(3, 7, 2, 9, 5);
		minNumInList(minNums);

//		6)
		List<String> strs = Arrays.asList("apple", "banana", "apricot", "cherry");
		startWithA(strs);

//		7)
		List<Integer> dupList = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
		removeDuplicates(dupList);

//		8)
		List<Integer> ascNums = Arrays.asList(4, 1, 3, 2);
		sortInAsc(ascNums);
		
//		9)
		List<Integer> descNums = Arrays.asList(4, 1, 3, 2);
		sortInDesc(descNums);
		
//		10)
		List<String> ch = Arrays.asList("a","b","c");
		firstElement(ch);
		
//		11)
		List<Integer> condsMatch = Arrays.asList(1,3,5,8); 
		checkConditionMatch(condsMatch);
		
//		12)
		List<String> nullContList = Arrays.asList("a", null, "b", null, "c");
		filterNull(nullContList);
		
//		13)
		List<Integer> secLarNum = Arrays.asList(5,9,1,9,3,7); 
		secondLargeNum(secLarNum);
		
//		14)
		List<String> words = Arrays.asList("a","","b","  ","c"); 
		removeEmpStrs(words);
		
//		15)
		List<Integer> partEvenAndOdd = Arrays.asList(1,2,3,4,5,6); 
		partEvenAndOddNums(partEvenAndOdd);

	}

//	1) Find all even numbers from a list 
	static void allEvenNums(List<Integer> list) {

		List<Integer> allEven = list.stream().filter(n -> n % 2 == 0).toList();

		System.out.println("Even numbers from list: " + allEven);

	}

//	2) Convert a list of strings to uppercase 
	static void stringdToUpperCase(List<String> names) {

//		List<String> names = Arrays.asList("java","stream","api");
//		
//		List<String> strToUpperCase = names.stream()
//										   .map(str -> str.toUpperCase())
//										   .collect(Collectors.toList());
//		
//		System.out.println(strToUpperCase);

		List<String> upper = names.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
		System.out.println(upper);

	}

//	3) Find the sum of all numbers in a list 
	static void sumOfNums(List<Integer> nums) {

		Integer sumOfNumsInList = nums.stream().mapToInt(Integer::intValue).sum();

		System.out.println(sumOfNumsInList);

	}

//	4) Find the maximum number in a list 
	static void maxNumInList(List<Integer> numbers) {

		int maxNum = numbers.stream().max(Comparator.comparing(Integer::intValue)).get();

		System.out.println(maxNum);

	}

//	5) Find the minimum number in a list
	static void minNumInList(List<Integer> numbers) {

		int minNum = numbers.stream().min(Comparator.comparing(Integer::intValue)).orElseThrow();

		System.out.println(minNum);

	}

//	6) Count strings starting with ‘a’
	static void startWithA(List<String> str) {

		long countTheStr = str.stream().filter(ch -> ch.startsWith("a")).count();

		System.out.println("The strings starts with a are: " + countTheStr);

	}

//	7) Remove duplicates from a list
	static void removeDuplicates(List<Integer> dupList) {

		List<Integer> noDupNums = dupList.stream().distinct().toList();

		System.out.println(noDupNums);

	}

//	8) Sort ascending
	static void sortInAsc(List<Integer> ascNums) {

		List<Integer> numsList = ascNums.stream().sorted().toList();

		System.out.println("Sorted in ascending order: " + numsList);

	}

//	9) Sort Descending
	static void sortInDesc(List<Integer> descNums) {

		List<Integer> numsList = descNums.stream().sorted(Comparator.reverseOrder()).toList();

		System.out.println("Sorted in descending order: " + numsList);

	}
	
//	10) Find first element
	static void firstElement(List<String> ch) {
		
		String firstEl = ch.stream()
						   .findFirst()
						   .orElse("Empty List");
		
		System.out.println("The first element in the list is: " + firstEl);
		
	}
	
//	11) Check if any element in the list matches a condition
	static void checkConditionMatch(List<Integer> condMatchList) {
		
		boolean matchConds = condMatchList.stream()
										.anyMatch(n -> n%2==0);
		
		System.out.println(matchConds);
												
	}
	
//	12) Filter null values from a list 
	static void filterNull(List<String> nullList) {
		
		List<String> nullCheck = nullList.stream()
										 .filter(Objects::nonNull)
										 .toList();
		
		System.out.println(nullCheck);
		
	}
	
//	13) Get the second-largest number in a list 
	static void secondLargeNum(List<Integer> nums) {
		
		int secondLrgNum = nums.stream()
							   .distinct()
							   .sorted(Comparator.reverseOrder())
							   .skip(1)
							   .findFirst()
							   .get();
		
		System.out.println("The second largest number in the list is " + secondLrgNum);
		
	}
	
//	14) Remove empty strings from a list 
	static void removeEmpStrs(List<String> words) {
		
		List<String> empStrs = words.stream()
									.map(String::trim)
									.filter(str -> !str.isBlank())
									.toList();
		
		System.out.println("Without empty strings: " + empStrs);
		
	}
	
//	15) Partition a list into even and odd numbers 
	static void partEvenAndOddNums(List<Integer> nums) {
		
		Map<Boolean, List<Integer>> partEvenOdd = nums.stream()
													  .collect(Collectors.partitioningBy(n -> n%2==0));
		
		System.out.println(partEvenOdd);
		
	}

}
