import java.lang.Math;
import java.util.List;

public class Trig implements AbstractCalculator
{
	private AbstractCalculator Calc;
	
	
	
	public Trig(AbstractCalculator Calc)
	{
		this.Calc = Calc;
		
		Calc.getOperators().add(new Operator("sine", (calc) -> {  sine(); }));
		Calc.getOperators().add(new Operator("cos", (calc) -> {  cosine(); }));
		Calc.getOperators().add(new Operator("tan", (calc) -> {  tangent(); }));
	}
	
	public void sine()
	{
		Calc.setAnswer(Math.sin(Calc.getInput1()));
	}
	
	public void cosine()
	{
		Calc.setAnswer(Math.cos(Calc.getInput1()));
	}
	
	public void tangent()
	{
		Calc.setAnswer(Math.tan(Calc.getInput1()));
	}

	@Override
	public void calculate() {
	
		
	}

	@Override
	public List<Operator> getOperators()
	{
		
		return Calc.getOperators();
	}

	@Override
	public void setInput1(double input1) 
	{
		Calc.setInput1(input1);
		
	}

	@Override
	public void setInput2(double input2) 
	{
		Calc.setInput2(input2);
		
	}

	@Override
	public void setAnswer(double answer) 
	{
		Calc.setAnswer(answer);
		
	}

	@Override
	public double getAnswer() 
	{
		return Calc.getAnswer();
	}

	@Override
	public double getInput1() 
	{
	
		return Calc.getInput1();
	}

	@Override
	public double getInput2() 
	{
	
		return Calc.getInput2();
	}
	 
	public void clear()
	{
		Calc.clear();
	}

		

}
