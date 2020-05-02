
public class SingletonCalculator 
{
	// create a single instance
	
	private static SingletonCalculator instance = new SingletonCalculator();
	
	//private constructor
	
	private SingletonCalculator()
	{
		// UI gets implemented here
	}
	
	public static SingletonCalculator getInstance()
	{
		return instance;
	}
	

	
}
