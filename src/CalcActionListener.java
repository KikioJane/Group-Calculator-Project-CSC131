import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcActionListener implements ActionListener
{
   private JButton B;
   
   public CalcActionListener(JButton b)
   {
      this.B = B;
	}
   
   public void actionPerformed(ActionEvent e) {
        CalculatorBase base = new CalculatorBase();
        char c = e.getActionCommand().charAt(0);
    }
}