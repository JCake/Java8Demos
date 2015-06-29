package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsDemo {
	public static void main(String[] args){
		List<Integer> intList = Arrays.asList(1,2,2,3,4,5,5,5,6,7,8,8,9,10);
		Set<Integer> intSet = new HashSet<>(intList);
		
		booleanChecks(intList); //intSet also works
//		calculations(intList);
//		mapping(intList, intSet);
//		filtering(intList, intSet);
//		methodChaining(intSet);
	}

	private static void booleanChecks(Collection<Integer> intCollection) {
		boolean allLessThan10 = intCollection.stream().allMatch(i -> i < 10);
		System.out.println("Are all numbers less than 10? " + allLessThan10);
		
		boolean allLessThanOrEqualTo10 = intCollection.stream().allMatch(i -> i <= 10);
		System.out.println("Are all numbers less than or equal to 10? " + allLessThanOrEqualTo10);
		
		boolean anyEven = intCollection.stream().anyMatch(i -> i % 2 == 0);
		System.out.println("Any even? " + anyEven);
		
		boolean anyNegative = intCollection.stream().anyMatch(i -> i < 0);
		System.out.println("Any negative? " + anyNegative);
		
		boolean nonNegative = intCollection.stream().noneMatch(i -> i < 0);
		System.out.println("None negative? " + nonNegative);
	}

	private static void calculations(List<Integer> intList) {
		Optional<Integer> maxValue = intList.stream().max(Integer::compareTo);
		System.out.println("Max value is: " + maxValue.get());
		
		Optional<Integer> minValue = intList.stream().min(Integer::compareTo);
		System.out.println("Min value is : " + minValue.get());
		
		Optional<Integer> maxValueOfNothing = new ArrayList<Integer>().stream().max(Integer::compareTo);
		System.out.println("Max of empty list: " + maxValueOfNothing);
		
		//mapToInt to get stream as ints (more map examples later)
		//Can NOT reuse streams - need new one for each calculation
		//IntStream intStream = intList.stream().mapToInt(Integer::valueOf);
		int sum = intList.stream().mapToInt(Integer::valueOf).sum();
		double average = intList.stream().mapToInt(Integer::valueOf).average().getAsDouble();
		System.out.println("sum: " + sum);
		System.out.println("average: " + average);
		
		//Use reduce for any calculation
		int product = intList.stream().mapToInt(Integer::valueOf).reduce(1, (a,b) -> a * b);
		System.out.println("product: " + product);
	}
	
	private static void mapping(List<Integer> intList, Set<Integer> intSet) {
		List<Integer> listDoubledToList = intList.stream().map(i -> i * 2).collect(Collectors.toList());
		Set<Integer> setDoubledToSet = intSet.stream().map(i -> i * 2).collect(Collectors.toSet());
		Set<Integer> listDoubledToSet = intList.stream().map(i -> i * 2).collect(Collectors.toSet());
		
		System.out.println("Original list: " + intList);
		System.out.println("Original set: " + intSet);
		System.out.println("List doubled to list: " + listDoubledToList);
		System.out.println("Set doubled to set: " + setDoubledToSet);
		System.out.println("List doubled to set: " + listDoubledToSet);
		
		List<Integer> outOfOrderList = Arrays.asList(5,2,7,1,9,3,4,5,9);
		List<Integer> sortedList = outOfOrderList.stream().sorted().collect(Collectors.toList());
		//Sorting on stream does NOT modify list in place
		System.out.println("Unordered:  " + outOfOrderList);
		System.out.println("Sorted: " + sortedList);
	}

	private static void filtering(List<Integer> intList, Set<Integer> intSet) {
		List<Integer> evenNumbers = intList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("even numbers: " + evenNumbers);
		
		Set<Integer> oddNumbers = intSet.stream().filter(i -> i % 2 == 1).collect(Collectors.toSet());
		System.out.println("odd numbers: " + oddNumbers);
		
		List<Integer> duplicatesList = Arrays.asList(4,4,7,1,2,9,2,1);
		List<Integer> noDuplicates = duplicatesList.stream().distinct().collect(Collectors.toList());
		System.out.println("With duplicates: " + duplicatesList);
		System.out.println("Duplicates removed: " + noDuplicates);
	}
	
	private static void methodChaining(Set<Integer> intSet) {
		int negativeSumOfEvensDividedBy2 = intSet.stream()
				.filter(i -> i % 2 == 0)
				.map(i -> i / 2)
				.reduce(0, (a,b) -> a - b);
		System.out.println("combo thingy: " + negativeSumOfEvensDividedBy2);
	}
}
