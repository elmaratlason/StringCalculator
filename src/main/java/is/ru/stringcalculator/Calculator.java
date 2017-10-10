package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String text){
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
		return Integer.parseInt(number);
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
}