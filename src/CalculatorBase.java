import java.util.LinkedList;
import java.util.List;

public class CalculatorBase implements AbstractCalculator
{
	// declare variables 
	private double input1;
	private double input2;
	private double answer;
	private List<Operator> operators;
		
	public CalculatorBase()
	{
		input1 = 0;					// initialize variable
		input2 = 0;
		answer = 0;
		operators = new LinkedList<Operator>();							// creates linked list
		
		operators.add(new Operator("C", (calc) ->{ clear();}));		// creates clear operator
		operators.add(new Operator("+", (calc) -> {  add(); }));		// creates add operator
		operators.add(new Operator("-", (calc) -> {  subtract(); }));	// creates subtract operator
		operators.add(new Operator("/", (calc) -> {  divide(); }));		// creates divide calculator
		operators.add(new Operator("*", (calc) -> {  multiply(); }));	// creates multiply operator
		
	}
	
	
//methods below are what happens when operator buttons get pressed
	
	public double getInput1()  // get input 1 method
	{
		return input1;
	}



	public void setInput1(double input1)
	{
		this.input1 = input1;		// sets input1 to current input
	}



	public double getInput2() {		// get input 2 method
		return input2;
	}



	public void setInput2(double input2) {
		this.input2 = input2;		// sets input2 to current input
	}



	public double getAnswer() {		// gets answer and returns it
		return answer;
	}



	public void setAnswer(double answer) {
		this.answer = answer;		// sets answer to the current answer from user input equation
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
		answer = input1 + input2;	// implementation of add
	}
	
	public void subtract()
	{
		answer = input1 - input2; 	// implementation of subtract
	}
	
	public void divide()
	{
		answer = input1/input2;		// implementation of divide
	}
	
	public void multiply()
	{
		answer = input1*input2;		// implementation of multiply
	}
	
	public void clear()
	{
		answer = 0;					// clears input and sets it to 0
	}
}

