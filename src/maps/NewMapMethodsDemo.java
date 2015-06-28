package maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewMapMethodsDemo {

	public static void main(String[] args){
		List<String> stringsToCount = Arrays.asList("cat","dog","cat","cat","fish","train","dog","train");
		
		Map<String,Integer> stringToCount = new HashMap<>();
		stringsToCount.forEach(string -> 	{	
			stringToCount.putIfAbsent(string, 0);
			stringToCount.replace(string, stringToCount.get(string) + 1);
		});
		stringToCount.forEach((string, count) -> System.out.println(count + " of " + string));
		
		System.out.println("****");
		
		Map<String,Integer> stringToCountAnotherWay = new HashMap<>();
		stringsToCount.forEach(string -> 	{	
			stringToCountAnotherWay.computeIfPresent(string, (key, value) -> value + 1);
			stringToCountAnotherWay.computeIfAbsent(string, (key) -> 1);
		});
		stringToCountAnotherWay.forEach((string, count) -> System.out.println(count + " of " + string));
		
		System.out.println("****");
		
		Map<String,Integer> stringToCountBestWay = new HashMap<>();
		stringsToCount.forEach(string -> 	{	
			stringToCountBestWay.compute(string, (key, value) -> value == null ? 1 : value + 1);
		});
		stringToCountBestWay.forEach((string, count) -> System.out.println(count + " of " + string));
	}
}
