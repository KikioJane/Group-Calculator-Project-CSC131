import java.util.List;

public interface AbstractCalculator {
	public void calculate();
	public List<Operator> getOperators();
	public void setInput1(double input1);
	public void setInput2(double input2);
	public void setAnswer(double answer);
	
	public double getAnswer();
	public double getInput1();
	public double getInput2();
	
	public void clear();

}
