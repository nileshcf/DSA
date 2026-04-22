package prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracStream {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));


		ArrayList<Integer> list = new ArrayList<>();
		Arrays.stream(arr).forEach(list::add);
		System.out.println(list);

		List<Integer> filteredList = list.stream().filter(x -> x>6).toList();
		System.out.println(filteredList);
		List<Integer> mul = list.stream().map(x -> x*x).toList();
		System.out.println(mul);

		// ============ MAP vs FLATMAP Demonstration ============

		System.out.println("\n========== MAP() vs FLATMAP() ==========\n");

		// --- MAP(): Transforms each element individually (1-to-1 mapping) ---
		System.out.println("--- MAP() Example ---");
		List<Integer> numbers = Arrays.asList(1, 2, 3);

		// map() transforms each number into a List, resulting in Stream<List<Integer>>
		// This creates a NESTED structure
		List<List<Integer>> mapResult = numbers.stream()
			.map(n -> Arrays.asList(n, n*2))  // Each number becomes [n, n*2]
			.toList();
		System.out.println("map() result: " + mapResult);
		// Output: [[1, 2], [2, 4], [3, 6]] - NESTED structure

		// --- FLATMAP(): Transforms and flattens (1-to-many mapping + flattening) ---
		System.out.println("\n--- FLATMAP() Example ---");

		// flatMap() transforms each number into a Stream, then FLATTENS all streams
		// This creates a FLAT structure
		List<Integer> flatMapResult = numbers.stream()
			.flatMap(n -> Arrays.stream(new Integer[]{n, n*2}))
			.toList();
		System.out.println("flatMap() result: " + flatMapResult);
		// Output: [1, 2, 2, 4, 3, 6] - FLATTENED structure

		// --- Practical Example: Word Splitting ---
		System.out.println("\n--- Practical Example: Splitting Sentences ---");
		List<String> sentences = Arrays.asList(
			"Hello World",
			"Java Streams",
			"Are Powerful"
		);

		// map() keeps nested structure
		List<String[]> mapWords = sentences.stream()
			.map(s -> s.split(" "))
			.toList();
		System.out.println("map() result (nested): " + mapWords.size() + " arrays");
		mapWords.forEach(wordArray -> System.out.println("  " + Arrays.toString(wordArray)));

		// flatMap() flattens all words into a single stream
		List<String> flatMapWords = sentences.stream()
			.flatMap(s -> Arrays.stream(s.split(" ")))
			.toList();
		System.out.println("flatMap() result (flattened): " + flatMapWords);
		// Output: [Hello, World, Java, Streams, Are, Powerful]

		// --- Key Difference Summary ---
		System.out.println("\n--- Key Differences ---");
		System.out.println("map():     Stream<T> -> Function -> Stream<R>      [Nesting preserved]");
		System.out.println("flatMap(): Stream<T> -> Function -> Stream<R>      [Streams merged/flattened]");
		System.out.println("           (Function returns Stream, which is then flattened)");

	}


}
