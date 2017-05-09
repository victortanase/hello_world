package testsekl;

import java.io.IOException;
//import java.util.function.Consumer;
//import java.util.function.Supplier;
import java.time.LocalDate;
import java.util.function.*;
import java.util.*;

public class FunctProgr {

	
	public static Optional<Double> average(int ... scores) {
	    if (scores.length == 0) return Optional.empty();
	    int sum = 0;
	    for (int score: scores) sum += score;
	    return Optional.of((double) sum / scores.length);
	 }
	
	public static void main(String [] args) throws IOException{
		
		Supplier<LocalDate> sup1 = LocalDate::now;
		Supplier<LocalDate> sup2 = () -> LocalDate.now();
		
		System.out.println(sup1.get());
		System.out.println(sup2.get());
		
		Supplier<StringBuilder> strbuild1 = StringBuilder::new;
		Supplier<StringBuilder> strbuild2 = () -> new StringBuilder();
		System.out.println(strbuild1);
		System.out.println(strbuild2);
		
		//Consumer
		
		Consumer<String> c1 = System.out::println;
		c1.accept("gaga");
		c1.accept("baba tzepara");
		BiConsumer<String,String> c11 =(z1,z2) -> System.out.println(z1+z2);;
		
		Map<String,String> map = new HashMap();
		BiConsumer<String,String> c2 = map::put;
		
		c2.accept("gaga", "sss");
		c2.accept("dsds", "dsdsdsds");

		map.forEach(c11);
		
		Predicate<String> p1 = String::isEmpty;
		System.out.println(p1.test("xx"));
		
		Predicate<String> egg = s -> s.contains("egg");
		Predicate<String> brown = s -> s.contains("brown");
		Predicate<String> brownEggs = egg.and(brown);
		Predicate<String> otherEggs = egg.and(brown.negate());
		boolean b = otherEggs.test("eggbrownn");
		c1.accept(Boolean.toString(b));
		
		Function<String,Integer> fct = String::length;
		c1.accept(Integer.toString(fct.apply("gagaccc")));
		
		BiFunction<String,String,String> fctbi = String::concat;
		c1.accept(fctbi.apply("mona", " o lalaie"));
		
		UnaryOperator<String> una = String::toUpperCase;
		c1.accept(una.apply("dsdsadsa"));
		
		
		BinaryOperator<String> biOp = String::concat;
		c1.accept(biOp.apply("mona", "facea mancare de fasole"));
		
		System.out.println(average(90, 100));
		System.out.println(average());
		
		Optional<Double> opt = average();
		System.out.println(opt.orElse(-999.0));
		System.out.println(opt.orElseGet(() ->Math.random()));
		System.out.println(opt.orElseThrow(() -> new IOException()));

		
	}
	

}
