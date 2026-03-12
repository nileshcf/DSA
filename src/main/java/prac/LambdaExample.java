package prac;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {
	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
				new Employee("Amit", 25, 60000),
				new Employee("Ravi", 30, 45000),
				new Employee("Neha", 28, 70000),
				new Employee("Kiran", 26, 52000)
		);

		// 👉 Use lambda here

		employees.stream()
				.filter(e ->e.salary>50000)
				.sorted((e1, e2) -> e1.name.compareTo(e2.name))
				.forEach(System.out::println);

	}
}
