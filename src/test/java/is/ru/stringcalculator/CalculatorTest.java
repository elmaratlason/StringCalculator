package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
	}	
	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}	
	@Test
	public void testTwoNumber(){
		assertEquals(3, Calculator.add("1,2"));
	}	
	@Test
	public void testMultipleNumbers(){
		assertEquals(6, Calculator.add("1,2,3"));
	}
	@Test
	public void testMultipleSplitwithNewline(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testMultipleSplitwithOnlyNewline(){
		assertEquals(6, Calculator.add("1\n2\n3"));
	}
	@Test
	public void testMultipleSplitwithNewlineComma(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testMultipleSplitwithCommaNewline(){
		assertEquals(6, Calculator.add("1\n2\n3"));
	}
	@Test
	public void testSplitwithNewline(){
		assertEquals(3, Calculator.add("1\n2"));
	}
	@Test(expected= IllegalArgumentException.class) 
	public void testNegatives(){
		Calculator.add("1,-2");
	}
	
	@Test
	public void testLargeNumber1(){
		assertEquals(2, Calculator.add("1000,2"));
	}

	@Test
	public void testLargeNumber2(){
		assertEquals(2, Calculator.add("0,2"));
	}
	@Test
	public void testVariantDelimiter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	
}
	
