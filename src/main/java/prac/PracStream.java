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



	}


}
