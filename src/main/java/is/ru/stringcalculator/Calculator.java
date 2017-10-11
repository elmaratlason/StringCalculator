package is.ru.stringcalculator;


public class Calculator {
private static int maxNum = 1000;
private static boolean debug = true;
	
	public static int add(String text){
		validate(text);
		if(text.equals(""))
			return 0;
		else{
			System.out.println("at sum " + text);
			return sum(getArray(text));
		}
	}
	
	private static int toint(String number){
		int temp = Integer.parseInt(number);
		if(temp < maxNum){
			return temp;
		}else{
			return 0;
		}
	}
	
	private static int sum(String [] numbers){
		int total = 0 ;
		for(String number : numbers){
			total += toint(number);
		}
		return total;
	}
	
	private static String [] getArray(String text){
		System.out.println("getArray: " + text);
		String delim = ",";
		String mynumbers[];
		if(text.contains("//")){
			doOutput("contains //");
			doOutput(text);
			String newText = text.substring(2);
			doOutput(newText);
			String line1[] = newText.split("\n", 2);
			delim = line1[0];
			doOutput("DELIM: " + delim);
			doOutput("LINE1: " + line1[1]);
			String numbers[] = line1[1].split(delim);
			return numbers;		
		}else{
			String temp = text.replaceAll("\n", ",");
			doOutput("TEMP2: " + temp);
			String numbers[] = temp.split(delim);
			return numbers;		
		}
			//return mynumbers;		
			
	}
	
		
	private static String validate(String text){
		String [] numbers = getArray(text);
		StringBuilder negatives = new StringBuilder();
		Boolean neg = false;
		for(String number : numbers){
			if(number.contains("-")){
				negatives.append(number);
				negatives.append(",");
				neg = true;
			}
		}
		if(neg){
			throw new IllegalArgumentException ("Negatives not allowed: " + negatives);
		}else{
			return text;
		}
		
	}
	
	private static void doOutput(String output){
		if(debug){
			System.out.println(output);
		}
	}
	
}