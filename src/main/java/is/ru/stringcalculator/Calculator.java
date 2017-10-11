package is.ru.stringcalculator;

public class Calculator {
public int maxNum = 1000;
	
	public static int add(String text){
		validate(text);
		if(text.equals(""))
			return 0;
		else{
			if(text.contains(",")){
				return sum(getArray(text));
			}else if(text.contains("\n")){
				return sum(getArray(text));
			}
		}
		return 1;
	}
	
	private static int toint(String number){
		int temp = Integer.parseInt(number);
		if(temp < 1000){
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
		
		String temp = text.replaceAll("\n", ",");
		String numbers[] = temp.split(",");
		
		return numbers;		
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
}