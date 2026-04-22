package prac;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaExample {
	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
				new Employee(1, "Alice",   75000, 30, "IT"),
				new Employee(2, "Bob",     45000, 25, "HR"),
				new Employee(3, "Charlie", 90000, 35, "IT"),
				new Employee(4, "Diana",   60000, 28, "Finance"),
				new Employee(5, "Eve",     45000, 22, "HR"),
				new Employee(6, "Frank",   95000, 40, "IT")
		);

		// 👉 Use lambda here

//		employees.stream()
//				.filter(e ->e.salary>50000)
//				.sorted((e1, e2) -> e1.name.compareTo(e2.name))
//				.forEach(System.out::println);

		employees.stream()
				.filter(e -> e.name.startsWith("A"))
				.toList()
				.forEach(System.out::println);

//		employees.stream()
//				.sorted((e1,e2)-> e1.salary>e2.salary?-1:1)
//				.forEach(System.out::println);

		// Sorting employees by salary in descending order
		employees.stream()
				.sorted((e1, e2) -> e1.salary > e2.salary ? -1 : 1)
				.forEach(System.out::println);

		// Filtering employees with salary greater than 50000
		employees.stream()
				.filter(e -> e.salary > 50000)
				.forEach(System.out::println);

		// Mapping employee names to uppercase
		employees.stream()
				.map(e -> e.name.toUpperCase())
				.forEach(System.out::println);

		// Counting employees in the IT department
		long itCount = employees.stream()
				.filter(e -> "IT".equals(e.dept))
				.count();
		System.out.println("IT Department Count: " + itCount);

		// Finding the employee with the highest salary
		employees.stream()
				.max((e1, e2) -> Double.compare(e1.salary, e2.salary))
				.ifPresent(System.out::println);

		// Finding the employee with the lowest salary
		employees.stream()
				.min((e1, e2) -> Double.compare(e1.salary, e2.salary))
				.ifPresent(System.out::println);

		// Grouping employees by department
		Map<String, List<Employee>> employeesByDepartment = employees.stream()
				.collect(Collectors.groupingBy(e -> e.dept));
		System.out.println(employeesByDepartment);

		// Joining employee names into a single string
		String employeeNames = employees.stream()
				.map(e -> e.name)
				.collect(Collectors.joining(", "));
		System.out.println("Employee Names: " + employeeNames);

		// Checking if all employees have a salary greater than 30000
		boolean allHighSalary = employees.stream()
				.allMatch(e -> e.salary > 30000);
		System.out.println("All employees have high salary: " + allHighSalary);

		// Checking if any employee is from the HR department
		boolean anyHR = employees.stream()
				.anyMatch(e -> "HR".equals(e.dept));
		System.out.println("Any employee from HR: " + anyHR);

		// Reducing to calculate the total salary of all employees
		double totalSalary = employees.stream()
				.map(e -> e.salary)
				.reduce(0.0, Double::sum);
		System.out.println("Total Salary: " + totalSalary);
	}
}
