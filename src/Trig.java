import java.lang.Math;
import java.util.List;

public class Trig implements AbstractCalculator
{
	private AbstractCalculator Calc;				// abstract calculator class object
	
	
	
	public Trig(AbstractCalculator Calc)
	{
		this.Calc = Calc;
		
		Calc.getOperators().add(new Operator("sine", (calc) -> {  sine(); }));		// creates sine operator
		Calc.getOperators().add(new Operator("cos", (calc) -> {  cosine(); }));		// creates cosine operator
		Calc.getOperators().add(new Operator("tan", (calc) -> {  tangent(); }));	// creates tanggent operator
	}
	
	public void sine()
	{
		Calc.setAnswer(Math.sin(Calc.getInput1()));		// compute the sin of the input
	}
	
	public void cosine()
	{
		Calc.setAnswer(Math.cos(Calc.getInput1()));		// compute the cosine of the user input
	}
	
	public void tangent()
	{
		Calc.setAnswer(Math.tan(Calc.getInput1()));		// compute the tangent of the user input
	}

	@Override
	public void calculate() {
	
		
	}

	@Override
	public List<Operator> getOperators()
	{
		
		return Calc.getOperators();				// gets the operator the user inputs
	}

	@Override
	public void setInput1(double input1) 		// input method
	{
		Calc.setInput1(input1);					// sets the user input as what they entered
		
	}

	@Override
	public void setInput2(double input2) 
	{
		Calc.setInput2(input2);
		
	}

	@Override
	public void setAnswer(double answer) 
	{
		Calc.setAnswer(answer);				// outputs the answer
		
	}

	@Override
	public double getAnswer() 
	{
		return Calc.getAnswer();			// gets the answer of the equation entered
	}

	@Override
	public double getInput1() 
	{
	
		return Calc.getInput1();			// method for retrieving input from user
	}

	@Override
	public double getInput2() 
	{
	
		return Calc.getInput2();
	}
	 
	public void clear()
	{
		Calc.clear();						// clears the user input
	}

		

}
