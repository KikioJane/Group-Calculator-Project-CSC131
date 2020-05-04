import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SingletonCalculator 
{
	// create a single instance	

	private static SingletonCalculator instance = new SingletonCalculator();
	
	//private constructor
	
	private SingletonCalculator()
	{
		AbstractCalculator calculator = new Trig(new CalculatorBase());
		
		
		JTextField calcentr;
      		JFrame frm = new JFrame();
		Container contentPane = frm.getContentPane();
      		JButton B = new JButton();
      		
		contentPane.setLayout(new GridLayout(7,1,2,2));
		
		JLabel calcnm = new JLabel("SAHO Calculator",JLabel.CENTER);
		frm.getContentPane().add(calcnm);
		
		calcentr = new JTextField("0");
		calcentr.setHorizontalAlignment(JTextField.RIGHT);
		frm.getContentPane().add(calcentr);
		
		ActionListener AL = new CalcActionListener(calcentr, calculator);
		
		JPanel r1 = new JPanel();								//Start row 1
		r1.setLayout(new GridLayout(1,4,2,2));
		frm.getContentPane().add(r1);
		for (int i=1; i<4; ++i)
      		{
			r1.add(B = new JButton(""+i));
			B.addActionListener(AL);
		}
		r1.add(B = new JButton ("+"));
		
		B.addActionListener(AL);
		JPanel r2 = new JPanel();								//Start row 2
		r2.setLayout(new GridLayout(1,4,2,2));
		frm.getContentPane().add(r2);
		for (int i=4; i<7; ++i)
      		{
			r2.add(B = new JButton(""+i));
			B.addActionListener(AL);
		}
		r2.add(B = new JButton ("-"));
		B.addActionListener(AL);
		
		JPanel r3 = new JPanel();								//Start row 3
		frm.getContentPane().add(r3);
		r3.setLayout(new GridLayout(1,4,2,2));
		for (int i=7; i<10; ++i)
      		{
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
	
	public static SingletonCalculator getInstance()
	{
		return instance;
	}
	

	
}
