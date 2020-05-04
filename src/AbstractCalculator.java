import java.util.List;

public interface AbstractCalculator {
	public void calculate();
	public List<Operator> getOperators();
	public void setInput1(double input1);		// set input1 method
	public void setInput2(double input2);		// set input2 method
	public void setAnswer(double answer);		// set answer method
	
	public double getAnswer();					// get answer 
	public double getInput1();					// get input1
	public double getInput2();					// get input2
	
	public void clear();

}
