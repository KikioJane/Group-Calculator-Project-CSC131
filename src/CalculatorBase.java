
public class CalculatorBase implements AbstractCalculator
{
	
	private double input1;
	private double input2;
	private double answer;
		
	public CalculatorBase()
	{
		input1 = 0;
		input2 = 0;
		answer = 0;
		
		
	}
	
	

	public double getInput1() 
	{
		return input1;
	}



	public void setInput1(double input1)
	{
		this.input1 = input1;
	}



	public double getInput2() {
		return input2;
	}



	public void setInput2(double input2) {
		this.input2 = input2;
	}



	public double getAnswer() {
		return answer;
	}



	public void setAnswer(double answer) {
		this.answer = answer;
	}



	@Override
	public void calculate() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOperators() 
	{
		// TODO Auto-generated method stub
		
	}
		
	public void add()
	{
		answer = input1 + input2;
	}
	
	public void subtract()
	{
		answer = input1 - input2; 
	}
	
	public void divide()
	{
		answer = input1/input2;
	}
	
	public void multiply()
	{
		answer = input1*input2;
	}
}

