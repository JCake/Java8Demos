package listsAndSets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class NewListAndSetMethodsDemo {
	public static void main(String[] args){
		List<Integer> intList = Arrays.asList(10,2,3,7,8,4,5,5,1,2,5,6,9,8);
		
		//Pre-Java 8:
		for(int i : intList){
			System.out.print(i + " ");
		}
		System.out.println();
		
		//Without lambdas:
		intList.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.print(t + " ");
			}
		});
		System.out.println();
		
		//With lambdas (shorthand for single interface method implementation)
		intList.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		//With lambdas referencing another method
		intList.forEach(NewListAndSetMethodsDemo::printInt);
		System.out.println();
		
		/******************************************/
		
		intList.sort(Integer::compareTo); //modifies in place
		intList.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
//		intList.removeIf(i -> i % 2 == 1); //unsupported -> new method on collections that does not apply to lists
//		intList.forEach(i -> System.out.print(i + " "));
		
		Set<Integer> intSet = new HashSet<>(intList);
		intSet.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		intSet.removeIf(i -> i % 3 != 0);
		intSet.forEach(i -> System.out.print(i + " "));
	}
	
	private static void printInt(int i){
		System.out.print(i + " ");
	}
}
