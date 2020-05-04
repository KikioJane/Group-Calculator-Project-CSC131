import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class CalcActionListener implements ActionListener
{
   private JButton B;
   JTextField display;
   String expression;
   
   public CalcActionListener(JButton B)
   {
      this.B = B;
   }
   
   
   
   public void actionPerformed(ActionEvent e) {
        char buttonInput = e.getActionCommand().charAt(0); // Needs to pass char to CalculatorBase
        
        //Creates a new expression and prevents first input of expression from being an operator
        if(expression == null && !isOperator(Character.toString(buttonInput)))
  		{	
  			expression = Character.toString(buttonInput);
  			display.setText(expression);
  		}
  		//Displays solution to expression and prevents last input of expression from being an operator
  		else if(buttonInput == '=' && !isOperator(Character.toString(expression.charAt(expression.length() - 1))))
  		{	
  			display.setText(Double.toString(calculateSolution(expression)));
  			expression = null;
  		}
  		//Clears display
  		else if(buttonInput == 'C')
  		{
  			display.setText("0.0");
  			expression = null;
  		}
  		//prevents multiple operands in a row
  		else if((isOperator(Character.toString(buttonInput)) &&
  				!isOperator(Character.toString(expression.charAt(expression.length() - 1)))) || 
  				(buttonInput >= '0' && buttonInput <= '9'))
  		{	
  			expression += Character.toString(buttonInput);
  			display.setText(expression);
  		}
  		else
  		{
  			display.setText("ERROR");
  			//Potentially wipe expression on error
  		}
   }
   
   Boolean isOperator(String s)
	{
		if(s.charAt(0) == '+' ||
		   s.charAt(0) == '-' ||
		   s.charAt(0) == '*' ||
		   s.charAt(0) == '/' ||
		   s.charAt(0) == '=' ||
		   s.charAt(0) == 'C')
		{
			return true;
		}
		return false;
	}
   
   Double calculateSolution(String expression)
	{
		Vector<Double> operand = new Vector<Double>(0);
		Vector<Character> operator = new Vector<Character>(0);
		int temp = 0;
		//parses expression into operands and operators with related index locations
		for(int i = 0; i < expression.length(); i++)
		{
			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
			{
				if(temp == 0)
					temp = Character.getNumericValue(expression.charAt(i));
				else
					temp = temp * 10 + Character.getNumericValue(expression.charAt(i));
			}
			else
			{
				operand.addElement(Double.valueOf(temp));
				temp = 0;
				operator.addElement(expression.charAt(i));
			}
		}
		operand.addElement(Double.valueOf(temp));
		temp = 0;
		
		
		CalculatorBase calc = new CalculatorBase();
		//evaluates multiplication and division fist
		for(int i = 0; i < operator.size(); i++)
		{
			if(operator.elementAt(i) == '*' || operator.elementAt(i) == '/')
			{
				calc.setInput1(operand.elementAt(i));
				calc.setInput2(operand.elementAt(i+1));
				if(operator.elementAt(i) == '*')
					calc.multiply();
				if(operator.elementAt(i) == '/')
					calc.divide();
				operand.set(i, calc.getAnswer());
				operand.remove(i+1);
				operator.remove(i);
				i--;
			}
		}
		//evaluates addition and subtraction last
		for(int i = 0; i < operator.size(); i++)
		{
			calc.setInput1(operand.elementAt(i));
			calc.setInput2(operand.elementAt(i+1));
			if(operator.elementAt(i) == '+')
				calc.add();
			if(operator.elementAt(i) == '-')
				calc.subtract();
			operand.set(i, calc.getAnswer());
			operand.remove(i+1);
			operator.remove(i);
			i--;
		}
		
		return operand.elementAt(0);
		
	}
}
