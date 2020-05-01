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
public class Calculator implements ActionListener {
	static JTextField calcentr;
	static double res = 0, opnd1= 0, opnd2 =0;
	static boolean newNumber = true;
	static char operator = ' ';
	public void actionPerformed(ActionEvent e) {
		char c = e.getActionCommand().charAt(0);
		switch(c) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': if (newNumber) {calcentr.setText(""+c); newNumber = false;}
				else calcentr.setText(calcentr.getText()+c);
				return;
			case '+': opnd1 = Double.parseDouble(calcentr.getText());
				newNumber = true;
				operator = '+';
				return;
			case '-': opnd1 = Double.parseDouble(calcentr.getText());
				newNumber = true;
				operator = '-';
				return;
			case '*': opnd1 = Double.parseDouble(calcentr.getText());
				newNumber = true;
				operator = '*';
				return;
			case '/': opnd1 = Double.parseDouble(calcentr.getText());
				newNumber = true;
				operator = '/';
				return;
			case '=': opnd2 = Double.parseDouble(calcentr.getText());
				switch (operator) {
					case '/': res = opnd1 / opnd2; break;
					case '*': res = opnd1 * opnd2; break;
					case '-': res = opnd1 - opnd2; break;
					case '+': res = opnd1 + opnd2; break;
				}
				calcentr.setText(""+res);
				newNumber = true;
				return;
			case 'C': {res = 0; newNumber = true; calcentr.setText("0.");}
         /* Implement set percentages for quick calculation of tips, feedback for what expression has been pressed last, trig functions, clear screen (already implemented), ANS button) */
		}
	} 

	void calculate() {
		ActionListener AL = new Calculator();
		JFrame frm = new JFrame();
		Container contentPane = frm.getContentPane();
		contentPane.setLayout(new GridLayout(7,1,2,2));
		JLabel calcnm = new JLabel("CSC 20 Lab 08",JLabel.CENTER);
		frm.getContentPane().add(calcnm);
		calcentr = new JTextField("0.");
		calcentr.setHorizontalAlignment(JTextField.RIGHT);
		frm.getContentPane().add(calcentr);
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
