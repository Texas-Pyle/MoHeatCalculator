import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonController extends MoHeatCalculator implements ActionListener  {
	private JButton button;
	public ButtonController(int xPos, int yPos, int widith, int height,String name) {
		this.button = new JButton(name);
		this.button.setBounds(xPos,yPos,widith,height);
		this.button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		getWindowsArray()[0].setVisible(false);
		getWindowsArray()[1].setVisible(true);
	}
	public JButton getButton() {
		return button;
	}
	
}
