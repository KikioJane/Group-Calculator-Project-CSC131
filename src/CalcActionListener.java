import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcActionListener implements ActionListener
{
   private JTextField textfield;
   private AbstractCalculator calculator;
   private Operator operator;
   
   public CalcActionListener(JTextField textfield, AbstractCalculator calculator)
   {
      this.textfield = textfield;
      this.calculator = calculator;
      this.operator = null;
            
	}
   
   public void actionPerformed(ActionEvent e) 
   {
        
        String c = e.getActionCommand(); // Needs to pass char to CalculatorBase
        
        // Any numeric key just updates the textfield
        if ((c.length() == 1) && Character.isDigit(c.charAt(0)))
        {
        	textfield.setText(textfield.getText() + c);
        }
        else
        {
        	// Any other key with the exception of equals sets the current textfield value as input and stores the operator
        	if (!c.equals("="))
        	{
        		if (!textfield.getText().isEmpty())
        		{
        			calculator.setInput1(Double.valueOf(textfield.getText()));      		
        		}
        		
        		operator = calculator.getOperators().stream().filter(op -> op.getSymbol().equals(c)).findFirst().get();
        		textfield.setText("");
        	}
        	else
        	{
        		// Store the current textfield input, call the oeprator function, and display the result in the textfield
        		
        		// Trig operators are unary functions
        		if (!operator.isUnary())
        		{
        			calculator.setInput2(Double.valueOf(textfield.getText()));
        		}
        		
        		operator.getCallback().accept(calculator);
        		textfield.setText(String.valueOf(calculator.getAnswer()));
        	}
        }
   }
}
