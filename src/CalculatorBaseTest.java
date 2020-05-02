import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorBaseTest {

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
