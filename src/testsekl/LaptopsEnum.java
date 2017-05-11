package testsekl;

public enum LaptopsEnum {
	Genti("Laptop, Tablete & Telefoane"), 
	Cooler("Standuri/Coolere laptop"), 
	HDD("Hard disk-uri"), 
	Laptopuri("Laptopuri"),
	Resigilate("Resigilate");  
	

	   private final String stringValue;
	   LaptopsEnum(final String s) { stringValue = s; }
		
	   public String toString() { System.out.println("test");
			        	return stringValue; }
}
