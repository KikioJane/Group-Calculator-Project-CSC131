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
        
        if (c.length() == 1) 
        {
        	// Non-alpha numeric assumes an operator of some type
        	if (!Character.isLetterOrDigit(c.charAt(0)))
        	{
        		if (!c.equals("="))
            	{
            		calculator.setInput1(Double.valueOf(textfield.getText()));      		
            		operator = calculator.getOperators().stream().filter(op -> op.getSymbol().equals(c)).findFirst().get();
            		textfield.setText("");
            	}
            	else
            	{
            		calculator.setInput2(Double.valueOf(textfield.getText()));
            		operator.getCallback().accept(calculator);
            		textfield.setText(String.valueOf(calculator.getAnswer()));
            	}
        	}
        	else if (Character.isDigit(c.charAt(0)))
        	{
        		textfield.setText(Double.valueOf(textfield.getText() + c).toString());
        	}
        }
    }
}
