package lists;

import java.util.Arrays;
import java.util.List;

public class NewListMethodsDemo {
	public static void main(String[] args){
		List<Integer> intList = Arrays.asList(10,2,3,7,8,4,5,5,1,2,5,6,9,8);
		
		intList.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		intList.sort(Integer::compareTo); //modifies in place
		intList.forEach(i -> System.out.print(i + " "));
	}
}
