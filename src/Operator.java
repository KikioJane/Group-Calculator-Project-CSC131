import java.util.function.Consumer;

public class Operator {

	private String symbol;
	private Consumer<AbstractCalculator> callback;
	
	public Operator(String symbol, Consumer<AbstractCalculator> callback)
	{
		this.symbol = symbol;
		this.callback = callback;
	}

	public String getSymbol() {
		return symbol;
	}

	public Consumer<AbstractCalculator> getCallback() {
		return callback;
	}
	
	
}
