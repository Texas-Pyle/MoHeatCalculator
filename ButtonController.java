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
		
		int currentWindow = calc.getCurrentWindow();
		switch (currentWindow){
		case 0:
			startMenue(e);
			break;
		case 1:
			heatTransfer(e);
			break;
		case 2: massTransfer(e);
			break;
		}
		
		
	}
	public JButton getButton() {
		return button;
	}
	private void startMenue(ActionEvent e) {
		JFrame[] windows = calc.getwindowArray();
		final int currentWindow = 0;
		final int heatTransfer = 1;
		final int massTransfer = 2;
		if(e.getActionCommand().equals("Heat Transfer")) {
			windows[heatTransfer].setLocation(windows[currentWindow].getLocation());
			windows[heatTransfer].setVisible(true);
			calc.setCurrentWindwo(1);
			windows[currentWindow].setVisible(false);
		}else {
			windows[massTransfer].setLocation(windows[currentWindow].getLocation());
			windows[massTransfer].setVisible(true);
			calc.setCurrentWindwo(2);
			windows[currentWindow].setVisible(false);
		}
		
	}private void heatTransfer(ActionEvent e) {
		JFrame[] windows = calc.getwindowArray();
		
	}
	private void massTransfer(ActionEvent e) {
		JFrame[] windows = calc.getwindowArray();
		final int startMenue = 0;
		final int currentWindow = 2;
		windows[startMenue].setLocation(windows[currentWindow].getLocation());
		windows[startMenue].setVisible(true);
		calc.setCurrentWindwo(0);
		windows[currentWindow].setVisible(false);
	}
	
}
