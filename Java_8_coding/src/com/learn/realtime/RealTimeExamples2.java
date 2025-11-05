package com.learn.realtime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RealTimeExamples2 {

	public static void main(String[] args) {
		
		List<Employee> empList = generateEmpList();
		
//		Print the names of all employees older than 30 years
		empList.stream()
				  .filter(e -> e.age > 30)
				  .forEach(e -> System.out.println(e.name));
		
//		List all distinct departments in alphabetical order
		List<String> res2 = empList.stream()
								   .map(e -> e.department)
								   .distinct()
								   .sorted()
								   .toList();
		System.out.println(res2);
				
//		Find the youngest employee in the organization
		Employee res3 = empList.stream()
							   .sorted(Comparator.comparing(e -> e.age))
							   .findFirst()
							   .get();
		System.out.println(res3);
		
//		Find the second-highest salary employee
		Employee res4 = empList.stream()
							   .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
							   .distinct()
							   .skip(1)
							   .findFirst()
							   .get();
		System.out.println(res4);
		
//		Get the list of employees whose names start with ‘A’
		List<Employee> res5 = empList.stream()
									 .filter(e -> e.getName().startsWith("A"))
									 .toList();
		System.out.println(res5);
		
//		Count of employees by gender and department
		Map<String, Map<String, Long>> res6 = empList.stream()
													 .collect(Collectors.groupingBy(Employee::getDepartment, 
															 	Collectors.groupingBy(Employee::getGender, Collectors.counting())
															 ));
		System.out.println(res6);
		
//		Find how many male and female employees are there in the organization.
		Map<String, Long> res7 = empList.stream()
										   .collect(Collectors.groupingBy(Employee::getGender, 
												   	Collectors.counting()
												   ));
		System.out.println(res7);
		
//		Print the names of all departments
		List<String> res8 = empList.stream()
								   .map(Employee::getDepartment)
								   .distinct()
								   .toList();
		System.out.println(res8);
							 
//		Average Age of Male and Female Employees
		Map<String, Double> res9 = empList.stream()
										  .collect(Collectors.groupingBy(Employee::getGender, 
												  	Collectors.averagingDouble(e -> e.getAge())
												  ));
		System.out.println(res9);
		
//		Names of employees who joined after 2015
		List<String> res10 = empList.stream()
									.filter(e -> e.getYearOfJoining() > 2015)
									.map(Employee::getName)
									.toList();
		System.out.println(res10);
		
//		Count of Employees in each Department
		Map<String, Long> res11 = empList.stream()
										 .collect(Collectors.groupingBy(Employee::getDepartment, 
												 	Collectors.counting()
												 ));
		System.out.println(res11);
		
//		Average salary of each Department
		Map<String, Double> res12 = empList.stream()
										   .collect(Collectors.groupingBy(Employee::getDepartment, 
												   	Collectors.averagingDouble(Employee::getSalary)
												   ));
		System.out.println(res12);
		
//		Find out the oldest Employee
		Employee res13 = empList.stream()
								.max(Comparator.comparing(Employee::getAge))
								.orElseThrow(() -> new RuntimeException("Employee Not Found"));
								
		System.out.println(res13);
		
//		Average and Total salary of the organization
		DoubleSummaryStatistics res14 = empList.stream()
			   .collect(Collectors.summarizingDouble(e -> e.getSalary()));
		System.out.println("Average Salary: " + res14.getAverage());
		System.out.println("Total Salary: " + res14.getSum());
		
//		Employees of each department
		Map<String, List<String>> res15 = empList.stream()
												 .collect(Collectors.groupingBy(Employee::getDepartment, 
														 	Collectors.mapping(Employee::getName, Collectors.toList())
														 ));
		System.out.println(res15);
		
//		Highest Experienced Employee
		Employee res16 = empList.stream()
								.min(Comparator.comparing(Employee::getYearOfJoining))
								.get();
		System.out.println(res16);
		
							   
		
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
