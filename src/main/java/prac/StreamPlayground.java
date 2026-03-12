package prac;

import java.util.Arrays;
import java.util.List;

public class StreamPlayground {
	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
				new Employee("Alice", 30, 60000),
				new Employee("Bob", 45, 80000),
				new Employee("Charlie", 25, 40000),
				new Employee("Charlie", 25, 40000),
				new Employee("David", 35, 75000),
				new Employee("Eve", 28, 52000),
				new Employee("Frank", 50, 90000),
				new Employee("Grace", 32, 48000)
		);




		employees.stream()
				.sorted((a,b)-> (int) (a.salary - b.salary))
				.forEach(System.out::println);

		employees.stream()
				.toList()
				.forEach(System.out::println);

		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World");
			}
		};
		r.run();


		Runnable r2 = () -> System.out.println("Hello World");
		r2.run();




	}


}
