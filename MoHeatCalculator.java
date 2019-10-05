import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MoHeatCalculator extends JFrame {
	private String[] buttonNames = {"Heat Transfer","Mass Transfer","Steady State","Un Steady State"};
	private String[] textFeildNames;
	private String[] windowNames = {"Start menue","Transfer selection","Heat Transfer"};
	private ButtonController[] buttons = new ButtonController[buttonNames.length];
	private JFrame[] windows = new JFrame[3] ;
	private MoHeatCalculator calc;
	public void GuiInitilizer() {
		//inlizing all frames
		
		
		for (int i = 0; i < windows.length; ++i) {
			windows[i] = new JFrame();
			windows[i].setSize(400,400);
			windows[i].setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			windows[i].setLayout(null);
		}//first frame gets 2 buttons
		for(int i = 0; i < 2; ++i) {
			int xpos = 130;
			int ypos = 40;
			int widith = 100;
			int height = 50;
			buttons[i] = new ButtonController(xpos,ypos + 60 * i,widith,height,buttonNames[i],calc);
			windows[0].add(buttons[i].getButton());
		}for (int i = 2; i < 4; ++i) {
			int xpos = 130;
			int ypos = 40;
			int widith = 100;
			int height = 50;
			buttons[i] = new ButtonController(xpos,ypos + 60 * i,widith,height,buttonNames[i],calc);
			windows[1].add(buttons[i].getButton());
		}
		windows[0].setVisible(true);
		
		
	}
	
	public static void main(String [] args) {
		MoHeatCalculator cal = new MoHeatCalculator();
		cal.setCalculatorObject(cal);
		cal.GuiInitilizer();
		
		
	}public JFrame[] getwindowArray() {
		return windows;
	}private void setCalculatorObject(MoHeatCalculator calc) {
		this.calc = calc;
	}

	
}
