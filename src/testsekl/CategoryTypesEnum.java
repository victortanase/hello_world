package testsekl;

public enum CategoryTypesEnum {
	LAPTOPS("Laptop, Tablete & Telefoane"), 
	PC("PC, Periferice & Software"), 
	Electrocasnice("Electrocasnice & Climatizare"), 
	TV("TV, Audio, Foto & Gaming"),
	SMART("Tehnologii SMART");  
	
	   private final String stringValue;
	   CategoryTypesEnum(final String s) { stringValue = s; }
	   public String toString() { return stringValue; }
}
