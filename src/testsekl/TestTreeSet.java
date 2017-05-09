package testsekl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestTreeSet {

	public static void print(Object s){
		System.out.println(s.toString());
	}
	
	public static void main(String [] args){
		
		Set<Integer> a = new TreeSet<Integer>();
		for (int i=0;i<=20;i++) a.add(i);
		
		//for(Integer j:a) print(j);
		NavigableSet<Integer> set=(NavigableSet<Integer>)a;
		print(set.ceiling(20));
		set.remove(1);
		print("ceiling: "+set.ceiling(1));
		print(set.floor(20));
		print(set.higher(10));
		print(set.lower(20));
		
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.offer(1);
		stack.offer(2);
		stack.push(12);
		print("acum");
		try{
		System.out.println(stack.remove());
		System.out.println(stack.remove());
		System.out.println(stack.remove());
		System.out.println(stack.remove());
		}catch(Exception e){
			print("gia!!!");
		}
		
		
		Map<String,String> mapa = new TreeMap<String,String>();
		mapa.put("gaga1", "unu");
		mapa.put("gaga2", "doi");
		mapa.put("gaga0", "doi");
		for(String s:mapa.values()){
			print(s);
		}
		List<Integer> lista = Arrays.asList(1,2,3,4);
		print(lista);
		lista.replaceAll(t -> t*2);
		print(lista);
		lista.forEach(c -> print(c));
		lista.forEach(TestTreeSet::print);
		
		
		
	}
}
