import java.util.function.Consumer;

public class Operator {

	private String symbol;													// declaring a string variavble
	private Consumer<AbstractCalculator> callback;
	
	public Operator(String symbol, Consumer<AbstractCalculator> callback)
	{
		this.symbol = symbol;												// takes the input symbol and stores it
		this.callback = callback;
	}

	public String getSymbol() {												// gets the symbol from user input
		return symbol;
	}

	public Consumer<AbstractCalculator> getCallback() {
		return callback;
	}
	
	
}
