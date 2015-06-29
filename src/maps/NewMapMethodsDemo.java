package maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NewMapMethodsDemo {

	public static void main(String[] args){
		List<String> stringsToCount = Arrays.asList("cat","dog","cat","cat","fish","train","dog","train");
		
		//Pre-Java 8
		Map<String,Integer> stringToCountOld = new HashMap<>();
		for(String s : stringsToCount){
			if(stringToCountOld.get(s) == null){
				stringToCountOld.put(s, 0);
			}
			stringToCountOld.put(s, stringToCountOld.get(s) + 1);
		}
		for(Entry<String,Integer> entry : stringToCountOld.entrySet()){
			System.out.println(entry.getValue() + " of " + entry.getKey());
		}
		
		System.out.println("****");
		
		//Various Java 8 options:
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
		
		Map<String,Integer> stringToCountShortestWay = new HashMap<>();
		stringsToCount.forEach(string -> 	{	
			stringToCountShortestWay.compute(string, (key, value) -> value == null ? 1 : value + 1);
		});
		stringToCountShortestWay.forEach((string, count) -> System.out.println(count + " of " + string));
	}
}
