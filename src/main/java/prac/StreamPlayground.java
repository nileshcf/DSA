package prac;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPlayground {
	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
				new Employee(1, "Alice",   75000, 30, "IT"),
				new Employee(2, "Bob",     45000, 25, "HR"),
				new Employee(3, "Charlie", 90000, 35, "IT"),
				new Employee(4, "Diana",   60000, 28, "Finance"),
				new Employee(5, "Eve",     45000, 22, "HR"),
				new Employee(6, "Frank",   95000, 40, "IT")
		);

		System.out.println("========== STREAM METHOD FUNCTIONAL INTERFACES ==========\n");

		// ============================================================
		// 1. FILTER() - Expects: Predicate<T>
		// ============================================================
		// Predicate<T> takes input T and returns boolean
		// Used to: Keep elements that satisfy the condition
		System.out.println("1. FILTER - Predicate<T>");
		System.out.println("   Interface: boolean test(T t)");
		System.out.println("   Input: T (Employee), Output: boolean");
		System.out.println("   Purpose: Keep only elements matching condition\n");

		employees.stream()
				.filter(e -> e.salary > 50000) // Predicate: returns true/false
				.forEach(System.out::println);

		// ============================================================
		// 2. MAP() - Expects: Function<T, R>
		// ============================================================
		// Function<T, R> takes input T and returns R
		// Used to: Transform each element to a different type/value
		System.out.println("\n2. MAP - Function<T, R>");
		System.out.println("   Interface: R apply(T t)");
		System.out.println("   Input: T (Employee), Output: R (String/Integer/etc)");
		System.out.println("   Purpose: Transform each element to different type\n");

		employees.stream()
				.map(e -> e.name) // Function: transforms Employee to String
				.forEach(System.out::println);

		// ============================================================
		// 3. SORTED() - Expects: Comparator<T>
		// ============================================================
		// Comparator<T> takes two inputs of type T and returns int
		// Used to: Sort elements based on comparison logic
		System.out.println("\n3. SORTED - Comparator<T>");
		System.out.println("   Interface: int compare(T o1, T o2)");
		System.out.println("   Input: T (Employee), T (Employee), Output: int");
		System.out.println("   Purpose: Sort elements based on comparison");
		System.out.println("   Returns: negative (o1<o2), 0 (o1==o2), positive (o1>o2)\n");

		employees.stream()
				.sorted((e1, e2) -> (int) (e1.salary - e2.salary)) // Comparator: compares two Employees
				.forEach(System.out::println);

		// ============================================================
		// 4. FOREACH() - Expects: Consumer<T>
		// ============================================================
		// Consumer<T> takes input T and returns void
		// Used to: Perform action on each element (side effect)
		System.out.println("\n4. FOREACH - Consumer<T>");
		System.out.println("   Interface: void accept(T t)");
		System.out.println("   Input: T (Employee), Output: void");
		System.out.println("   Purpose: Perform action on each element (terminal operation)\n");

		employees.stream()
				.forEach(e -> System.out.println(e)); // Consumer: accepts Employee and prints

		// ============================================================
		// 5. FILTER with complex conditions - Predicate<T>
		// ============================================================
		System.out.println("\n5. FILTER with Multiple Conditions - Predicate<T>");
		System.out.println("   Using short form (without brackets):");

		employees.stream()
				.filter(e -> e.salary > 50000 && e.getDept().equals("IT"))
				.forEach(System.out::println);

		System.out.println("   Using long form (with brackets):");

		employees.stream()
				.filter(e -> {
					if (e.getSalary() > 50000 && e.getDept().equals("IT"))
						return true;
					return false;
				})
				.forEach(System.out::println);

		// ============================================================
		// 6. FLATMAP() - Expects: Function<T, Stream<R>>
		// ============================================================
		// Function<T, Stream<R>> takes input T and returns Stream<R>
		// Used to: Transform each element into a Stream and flatten
		System.out.println("\n6. FLATMAP - Function<T, Stream<R>>");
		System.out.println("   Interface: Stream<R> apply(T t)");
		System.out.println("   Input: T (Employee), Output: Stream<R>");
		System.out.println("   Purpose: Map and flatten multiple values per element\n");

		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		names.stream()
				.flatMap(name -> Arrays.stream(name.split(""))) // Function: returns Stream<String>
				.forEach(System.out::println);

		// ============================================================
		// 7. MAX() / MIN() - Expects: Comparator<T>
		// ============================================================
		System.out.println("\n7. MAX / MIN - Comparator<T>");
		System.out.println("   Interface: int compare(T o1, T o2)");
		System.out.println("   Input: T (Employee), T (Employee), Output: int");
		System.out.println("   Purpose: Find max/min element based on comparison\n");

		employees.stream()
				.max((e1, e2) -> (int) (e1.salary - e2.salary)) // Comparator
				.ifPresent(e -> System.out.println("Max Salary: " + e));

		employees.stream()
				.min((e1, e2) -> (int) (e1.salary - e2.salary)) // Comparator
				.ifPresent(e -> System.out.println("Min Salary: " + e));

		// ============================================================
		// 8. ALLMATCH() / ANYMATCH() / NONEMATCH() - Expects: Predicate<T>
		// ============================================================
		System.out.println("\n8. ALLMATCH / ANYMATCH / NONEMATCH - Predicate<T>");
		System.out.println("   Interface: boolean test(T t)");
		System.out.println("   Input: T (Employee), Output: boolean");
		System.out.println("   Purpose: Check if all/any/none elements match condition\n");

		boolean allHighSalary = employees.stream()
				.allMatch(e -> e.salary > 30000); // Predicate: checks all
		System.out.println("All have salary > 30000: " + allHighSalary);

		boolean anyFromIT = employees.stream()
				.anyMatch(e -> "IT".equals(e.getDept())); // Predicate: checks any
		System.out.println("Any from IT: " + anyFromIT);

		boolean noneFromMarketing = employees.stream()
				.noneMatch(e -> "Marketing".equals(e.getDept())); // Predicate: checks none
		System.out.println("None from Marketing: " + noneFromMarketing);

		// ============================================================
		// 9. REDUCE() - Expects: BinaryOperator<T>
		// ============================================================
		// BinaryOperator<T> takes two inputs of type T and returns T
		// Used to: Combine all elements into single value
		System.out.println("\n9. REDUCE - BinaryOperator<T>");
		System.out.println("   Interface: T apply(T t1, T t2)");
		System.out.println("   Input: T (Double), T (Double), Output: T (Double)");
		System.out.println("   Purpose: Combine all elements into single result\n");

		double totalSalary = employees.stream()
				.map(e -> e.salary)
				.reduce(0.0, (sum, salary) -> sum + salary); // BinaryOperator: combines two doubles
		System.out.println("Total Salary: " + totalSalary);

		// ============================================================
		// 10. COLLECT() - Expects: Collector<T, A, R>
		// ============================================================
		System.out.println("\n10. COLLECT - Collector<T, A, R>");
		System.out.println("   Interface: Complex - typically uses predefined Collectors");
		System.out.println("   Purpose: Accumulate stream elements into container\n");

		String employeeNames = employees.stream()
				.map(e -> e.name)
				.collect(Collectors.joining(", ")); // Collector: joins strings
		System.out.println("Names: " + employeeNames);

		// ============================================================
		// 11. STRING OPERATIONS (Advanced Streams)
		// ============================================================
		System.out.println("\n11. STRING STREAM OPERATIONS");
		System.out.println("   Converts String to stream of characters\n");

		String text = "hello";
		System.out.print("Characters in uppercase: ");
		text.chars() // IntStream of character codes
				.mapToObj(c -> (char) c) // Convert int to Character
				.map(Character::toUpperCase) // Function<Character, Character>
				.forEach(System.out::print);

		System.out.println("\n\n   Word to individual chars:");
		text.chars()
				.mapToObj(c -> String.valueOf((char) c))
				.forEach(System.out::println);

		// ============================================================
		// 12. CHAINING MULTIPLE OPERATIONS
		// ============================================================
		System.out.println("\n12. CHAINING OPERATIONS (All Functional Interfaces)");
		System.out.println("   Filter (Predicate) -> Map (Function) -> Sorted (Comparator) -> ForEach (Consumer)\n");

		employees.stream()
				.filter(e -> e.salary > 40000) // Predicate<Employee> - boolean test(Employee)
				.map(e -> e.name.toUpperCase()) // Function<Employee, String> - String apply(Employee)
				.sorted() // Comparator<String> - int compare(String, String)
				.forEach(System.out::println); // Consumer<String> - void accept(String)

	}


}
