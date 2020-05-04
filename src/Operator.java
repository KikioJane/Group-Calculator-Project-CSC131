import java.util.function.Consumer;

public class Operator {

	private String symbol;													// declaring a string variavble
	private Consumer<AbstractCalculator> callback;
	private boolean unary;
	
	public Operator(String symbol, Consumer<AbstractCalculator> callback)
	{
		this.symbol = symbol;												// takes the input symbol and stores it
		this.callback = callback;
		this.unary = false;
	}
	
	public Operator(String symbol, Consumer<AbstractCalculator> callback, boolean unary)
	{
		this.symbol = symbol;												// takes the input symbol and stores it
		this.callback = callback;
		this.unary = unary;
	}

	public boolean isUnary()
	{
		return unary;
	}
	
	public String getSymbol() {												// gets the symbol from user input
		return symbol;
	}

	public Consumer<AbstractCalculator> getCallback() {
		return callback;
	}
	
	
}
