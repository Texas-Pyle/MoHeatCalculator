import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonController extends Frame implements ActionListener  {
	private JButton button;
	private MoHeatCalculator calc;
	public ButtonController(int xPos, int yPos, int widith, int height,String name,MoHeatCalculator calc ) {
		this.button = new JButton(name);
		this.button.setBounds(xPos,yPos,widith,height);
		this.button.addActionListener(this);
		this.calc = calc;
	}
	
	public void actionPerformed(ActionEvent e) {
		JFrame[] windows = calc.getwindowArray();
		windows[1].setVisible(true);
		windows[0].setVisible(false);
		
	}
	public JButton getButton() {
		return button;
	}
	
}
