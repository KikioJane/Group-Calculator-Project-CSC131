import java.util.LinkedList;
import java.util.List;

public class CalculatorBase implements AbstractCalculator
{
	
	private double input1;
	private double input2;
	private double answer;
	private List<Operator> operators;
		
	public CalculatorBase()
	{
		input1 = 0;
		input2 = 0;
		answer = 0;
		operators = new LinkedList<Operator>();
		
		operators.add(new Operator("+", (calc) -> {  add(); }));
		operators.add(new Operator("-", (calc) -> {  subtract(); }));
		operators.add(new Operator("/", (calc) -> {  divide(); }));
		operators.add(new Operator("*", (calc) -> {  multiply(); }));
		
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
	public List<Operator> getOperators() 
	{
		
		return operators;
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
	
	public void clear()
	{
		answer = 0;
	}
}

