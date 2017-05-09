package testsekl;

import java.util.Optional;

public class Lambda4 {

    static int outerStaticNum=0;
    int outerNum=0;
    
    void testScopes(){
    	
    	Converter <String, Integer> conv = (from) -> {
    		outerNum =24;
    		return Integer.parseInt(from);
    	};
    	
    	Converter <String, Integer> conv2 = (from) ->{
    		outerStaticNum=22;
    		return Integer.parseInt(from);
    	};
    	
    	System.out.println(conv.convert("123"));
    	System.out.println(conv2.convert("124"));
    	System.out.println("outerStaticNum: "+outerStaticNum);
    	System.out.println("outerNum: "+outerNum);
    	
    }
    
    public static void main(String [] args){
    	//Lambda4 l1 =new Lambda4();
    	//l1.testScopes();
    	double x= Math.random()*1;
    	System.out.println(x);
    	Optional<String> s = (x>2) ? Optional.of("gaga"):Optional.empty();
    	s.ifPresent(System.out::println);
    	System.out.println(s.orElseGet(() ->new String("gagaeee")) );
    	
    }
}
