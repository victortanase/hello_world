package testsekl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exemplu {
	
	
	public static void main(String [] args){
		
		List<String> arie = Arrays.asList("aa","ccc","accc","ddd", "anna", "mike", "xenia");
		
		Collections.sort(arie,(String a, String b) ->b.compareTo(a));
		
		for(String str :arie){
			System.out.println(str);
		}
		Converter<String, Integer> conv = Integer::valueOf;
		int gaga = conv.convert("1");
		System.out.println(gaga);
		
		
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");

	}

}
