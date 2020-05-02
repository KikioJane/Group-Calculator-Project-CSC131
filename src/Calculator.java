/*
 * Calculator : Team Project Deliverable
 * The SCRUM-at-Home Order
 * Thomas Rich, Trevor Davis, Mimi Xue
 * Jessica Lynn, Heavenly Khosa
 * CSC 131 - 02
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Calculator implements ActionListener {
	static JTextField display;
	static double res = 0, opnd1= 0, opnd2 =0;
	static boolean newNumber = true;
	static char operator = ' ';
	String expression;
	
	/*
	 * Based on button press:
	 *  - Displays and stores full expression 
	 *  - Clears to 0
	 *  - Calculates equation with PEMDAS
	 */
	public void actionPerformed(ActionEvent e) {
		char buttonInput = e.getActionCommand().charAt(0);
		
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
		
		/*Implement set percentages for quick calculation of tips,  
		 * trig functions,  
		 * ANS button)
		 */
		
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
		
		//evaluates multiplication and division fist
		for(int i = 0; i < operator.size(); i++)
		{
			if(operator.elementAt(i) == '*')
			{
				operand.set(i, operand.elementAt(i) * operand.elementAt(i+1));
				operator.remove(i);
				operand.remove(i+1);
				i--;
			}
			else if(operator.elementAt(i) == '/')
			{
				operand.set(i, operand.elementAt(i) / operand.elementAt(i+1));
				operator.remove(i);
				operand.remove(i+1);
				i--;
			}
		}
		//evaluates addition and subtraction last
		for(int i = 0; i < operator.size(); i++)
		{
			if(operator.elementAt(i) == '+')
			{
				operand.set(i, operand.elementAt(i) + operand.elementAt(i+1));
				operator.remove(i);
				operand.remove(i+1);
				i--;
			}
			else if(operator.elementAt(i) == '-')
			{
				operand.set(i, operand.elementAt(i) - operand.elementAt(i+1));
				operator.remove(i);
				operand.remove(i+1);
				i--;
			}
		}
		
		return operand.elementAt(0);
		
	}
	
	void calculate() {
		ActionListener AL = new Calculator();
		JFrame frm = new JFrame();
		Container contentPane = frm.getContentPane();
		contentPane.setLayout(new GridLayout(7,1,2,2));
		JLabel calcnm = new JLabel("CSC 20 Lab 08",JLabel.CENTER);
		frm.getContentPane().add(calcnm);
		display = new JTextField("0.");
		display.setHorizontalAlignment(JTextField.RIGHT);
		frm.getContentPane().add(display);
		JPanel r1 = new JPanel();								//Start row 1
		r1.setLayout(new GridLayout(1,4,2,2));
		frm.getContentPane().add(r1);
		JButton B;
		for (int i=1; i<4; ++i) {
			r1.add(B = new JButton(""+i));
			B.addActionListener(AL);
		}
		r1.add(B = new JButton ("+"));
		B.addActionListener(AL);
		JPanel r2 = new JPanel();								//Start row 2
		r2.setLayout(new GridLayout(1,4,2,2));
		frm.getContentPane().add(r2);
		for (int i=4; i<7; ++i) {
			r2.add(B = new JButton(""+i));
			B.addActionListener(AL);
		}
		r2.add(B = new JButton ("-"));
		B.addActionListener(AL);
		JPanel r3 = new JPanel();								//Start row 3
		frm.getContentPane().add(r3);
		r3.setLayout(new GridLayout(1,4,2,2));
		for (int i=7; i<10; ++i) {
			r3.add(B = new JButton(""+i));
			B.addActionListener(AL);
		}
		r3.add(B = new JButton ("*"));
		B.addActionListener(AL);
		JPanel r4 = new JPanel();								//Start row 4
		frm.getContentPane().add(r4);
		r4.setLayout(new GridLayout(1,2,2,2));
		r4.add(B = new JButton ("C"));
		B.addActionListener(AL);
		JPanel r4c2 = new JPanel();
		r4.add(r4c2);
		r4c2.setLayout(new GridLayout(1,2,2,2));
		r4c2.add(B = new JButton ("0"));
		B.addActionListener(AL);
		r4c2.add(B = new JButton ("/"));
		B.addActionListener(AL);
		contentPane.add(B = new JButton ("="));						//Start row 5
		B.addActionListener(AL);
		frm.pack();
		frm.setSize(318,220);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
