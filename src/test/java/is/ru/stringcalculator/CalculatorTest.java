package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorTest {
private static boolean printseperator = false;
private static String seperator = "#### ";
private static int testCounter = 0;
	@Test
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testTwoNumber(){
		assertEquals(3, Calculator.add("1,2"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testMultipleNumbers(){
		assertEquals(6, Calculator.add("1,2,3"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testMultipleSplitwithNewline(){
		assertEquals(6, Calculator.add("1\n2,3"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testMultipleSplitwithOnlyNewline(){
		assertEquals(6, Calculator.add("1\n2\n3"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testMultipleSplitwithNewlineComma(){
		assertEquals(6, Calculator.add("1\n2,3"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testMultipleSplitwithCommaNewline(){
		assertEquals(6, Calculator.add("1\n2\n3"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testSplitwithNewline(){
		assertEquals(3, Calculator.add("1\n2"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test(expected= IllegalArgumentException.class) 
	public void testNegatives(){
		Calculator.add("1,-2");
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	
	@Test
	public void testLargeNumber1(){
		assertEquals(2, Calculator.add("1000,2"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}

	@Test
	public void testLargeNumber2(){
		assertEquals(2, Calculator.add("0,2"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testVariantDelimiter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	@Test
	public void testVariantDelimiter1(){
		assertEquals(8, Calculator.add("//x\n1x7"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	public void testVariantDelimiter3(){
		assertEquals(10, Calculator.add("//:\n1:7:2"));
		if(printseperator)
			System.out.println(seperator + testCounter);
		testCounter++;
	}
	
}
	
