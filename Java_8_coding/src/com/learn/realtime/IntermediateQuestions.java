package com.learn.realtime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IntermediateQuestions {
	
	public static void main(String[] args) {
		
		List<Employee> empList = generateEmpList();
		
//		Find the names of the top 3 employees earning the highest salaries
		List<String> res1 = empList.stream()
								   .sorted(Comparator.comparing(Employee::getSalary).reversed())
								   .map(Employee::getName)
								   .limit(3)
								   .toList();
		System.out.println(res1);
		
//		Highest Paid Employee in Each Department
		Map<String, String> res2 = empList.stream()
										  .collect(Collectors.groupingBy(Employee::getDepartment, 
												  	Collectors.collectingAndThen(
												  			Collectors.maxBy(Comparator.comparing(Employee::getSalary)), 
												  			e -> e.get().getName())
												  ));
		System.out.println(res2);
		
//		Total Salary Paid to Each Department
		Map<String, Double> res3 = empList.stream()
										  .collect(Collectors.groupingBy(Employee::getDepartment, 
												  	Collectors.summingDouble(Employee::getSalary)
												  ));
		System.out.println(res3);
		
//		Highest Salary Among Males and Females
		Map<String, String> res4 = empList.stream()
										  .collect(Collectors.groupingBy(Employee::getGender, 
												  	Collectors.collectingAndThen(
												  			Collectors.maxBy(Comparator.comparing(Employee::getSalary)), 
												  			e -> e.get().getName())
												  ));
		System.out.println(res4);
		
	}
	
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
	
}
