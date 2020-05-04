import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorBaseTest {

	//Tests for CalculatorBase.java
	
	@Test
	public void input()
	{
		CalculatorBase calc = new CalculatorBase();
		calc.setInput1(5);
		calc.setInput2(10);
		calc.setAnswer(15);
		calc.getInput1();
		calc.getInput2();
		calc.getAnswer();
		
		
		assertEquals("getInput1()", 5, calc.getInput1(), 0);
		assertEquals("getInput2()", 10, calc.getInput2(), 0);
		assertEquals("getAnswer()", 15, calc.getAnswer(), 0);
	}
	
	@Test
	public void add() 
	{
		
		CalculatorBase calc = new CalculatorBase();
		calc.setInput1(60);
		calc.setInput2(40);
		calc.add();
		
		assertEquals("add()", 100, calc.getAnswer(),.0001);
		
		
	}
	
	@Test
	public void subtract()
	{
		CalculatorBase calc = new CalculatorBase();
		calc.setInput1(50);
		calc.setInput2(5);
		calc.subtract();
		
		assertEquals("subtract()", 45, calc.getAnswer(), .0001);
		
	}
	
	@Test
	public void divide()
	{
		CalculatorBase calc = new CalculatorBase();
		calc.setInput1(50);
		calc.setInput2(5);
		calc.divide();
		
		assertEquals("divide()", 10, calc.getAnswer(), .0001);
	}
	
	@Test
	public void multiply()
	{
		CalculatorBase calc = new CalculatorBase();
		calc.setInput1(5);
		calc.setInput2(6);
		calc.multiply();
		
		assertEquals("multiply()", 30, calc.getAnswer(), .0001);
	
	}
	
	@Test
	public void clear()
	{
		CalculatorBase calc = new CalculatorBase();
		calc.clear();
		calc.getAnswer();
		
		assertEquals("clear()", 0, calc.getAnswer(), 0);
	}
	
	//Tests for Trig.java
	
	@Test
	public void sine()
	{
		Trig trigfunctions = new Trig( new CalculatorBase() );
		trigfunctions.setInput1(5);
		trigfunctions.sine();
		
		assertEquals("sine()", -0.958924, trigfunctions.getAnswer(), .01);
	}
	
	@Test
	public void cosine()
	{
		Trig trigfunctions = new Trig(new CalculatorBase() );
		trigfunctions.setInput1(5);
		trigfunctions.cosine();
		
		assertEquals("cosine()", 0.28366, trigfunctions.getAnswer(), .01);
	}
	
	@Test
	public void tangent()
	{
		Trig trigfunctions = new Trig(new CalculatorBase() );
		trigfunctions.setInput1(5);
		trigfunctions.tangent();
		
		assertEquals("tangent()", -3.3805, trigfunctions.getAnswer(), .01);
	}
}
