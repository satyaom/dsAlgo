import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;

class Practice {
	public static void main(String[] args) {
		List<Integer> event = Stream.of(Arrays.asList(2, 4, 6), Arrays.asList(1, 2, 3))
		.flatMap(list -> list.stream())
		.distinct()
		.collect(Collectors.toList());

		System.out.println(event);
	}
}