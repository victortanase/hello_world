package testsekl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExamples {

	public static void main(String[] args){
		Stream<Double> str1 =Stream.generate(Math::random);
		Stream<Integer> oddNumbers = Stream.iterate(1,n ->n +2);
		
		Consumer<Object> c = System.out::println;
		//Stream<String> sa = Stream.of("1","2","3");
		//System.out.println(sa.count());
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		//s.map(String::length).forEach(System.out::print);
		s.distinct().forEach(x ->System.out.print(x + " "));
		System.out.println("");
		
		List<String> list = Arrays.asList("unu4","doi4","trei7","55");
		list.stream()
		.peek(x ->System.out.println("peek1" + x))
		.filter(n ->n.length() == 4 )
		.sorted()
		.peek(x ->System.out.println("peek2" + x))
		.limit(2)
		.forEach(System.out::println);
		
		IntStream intstr1 = (new Random()).ints();
		intstr1.limit(10)
		.forEach(System.out::println);
		
		IntStream rangeClosed = IntStream.rangeClosed(1, 5);
		rangeClosed.forEach(System.out::println);
		
		
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		String result = ohMy.collect(Collectors.joining(",p "));
		System.out.println(result);
		ohMy = Stream.of("lions", "tigers", "bears");
		Double result2 = ohMy.collect(Collectors.averagingInt(String::length));
		c.accept(result2);
		ohMy = Stream.of("lions", "tigers", "bears");
		List<String> listamea = ohMy.collect(Collectors.toList());
	    c.accept(listamea);			
	}
}
