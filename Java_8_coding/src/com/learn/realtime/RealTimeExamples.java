package com.learn.realtime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RealTimeExamples {

	public static List<Employee> generateEmpList() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(101, "AAA", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(102, "BBB", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(103, "CCC", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(104, "DDD", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(105, "EEE", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(106, "FFF", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(107, "GGG", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(108, "HHH", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(109, "III", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(110, "JJJ", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(111, "KKK", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(112, "LLL", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(113, "MMM", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(114, "NNN", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(115, "OOO", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(116, "PPP", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(117, "QQQ", 31, "Male", "Product Development", 2012, 35700.0));
		return employeeList;
	}

	public static void main(String[] args) {

		List<Employee> list1 = generateEmpList();
		
//		Male and Female Count
		Map<String, Long> res1 = list1.stream()
										 .collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()));
		System.out.println(res1);
		
//		Print the names of all departments
		List<String> res2 = list1.stream()
						   .map(e -> e.department)
						   .distinct()
						   .toList();
		System.out.println(res2);
		
//		Average Age of Male and Female Employees
		Map<String, Double> res3 = list1.stream()
										.collect(Collectors.groupingBy(e -> e.gender, Collectors.averagingInt(e -> e.age)));
		System.out.println(res3);
					
//		Names of employees who joined after 2015
		List<String> res4 = list1.stream()
								 .filter(e -> e.yearOfJoining > 2015)
								 .map(e -> e.name)
								 .toList();
		System.out.println(res4);
		
		Map<Integer,List<String>> empNamesByYear = list1.stream()
				.filter(e->e.yearOfJoining>2015).collect(Collectors.groupingBy(e->e.yearOfJoining,
				Collectors.mapping(e -> e.name, Collectors.toList())));
		System.out.println(empNamesByYear);
		
//		Count of Employees in each Department
		Long res5 = list1.stream()
						 .count();
		System.out.println(res5);
		
//		Average salary of each Department
		Map<String, Double> res6 = list1.stream()
										.collect(Collectors.groupingBy(e -> e.department, Collectors.averagingDouble(e -> e.salary)));	
		System.out.println(res6);
		
//		Find out the oldest Employee
		Optional<Employee> res7 = list1.stream().max(Comparator.comparingInt(e->e.age));
		System.out.println(res7.get().name);
		
//		Average and Total salary of the organization
		DoubleSummaryStatistics res8 = list1.stream()
								   		.collect(Collectors.summarizingDouble(e -> e.salary));
		System.out.println(res8.getAverage());
		System.out.println(res8.getSum());
		
//		Collectors.summarizingDouble() gives you:
//
//			getCount() → number of employees
//
//			getSum() → total salary
//
//			getAverage() → average salary
//
//			getMin() → lowest salary
//
//			getMax() → highest salary
		
//		Employees of each department
		Map<String, List<String>> res9 = list1.stream()
												.collect(Collectors.groupingBy(
															e -> e.department, 
															Collectors.mapping(e -> e.name, Collectors.toList())
												));
		System.out.println(res9);
		
//		Highest Experienced Employee
		Optional<Employee> seniorEmployee = list1.stream()
												 .sorted(Comparator.comparingInt(e->e.yearOfJoining))
												 .findFirst();
		System.out.println(seniorEmployee.get().name);

	}

}
