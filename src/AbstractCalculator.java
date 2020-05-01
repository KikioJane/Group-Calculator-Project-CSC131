import java.util.List;

public interface AbstractCalculator {
	public void calculate();
	public List<Operator> getOperators();
	public void setInput1(double input1);
	public void setInput2(double input2);
	public double getAnswer();
	
}
