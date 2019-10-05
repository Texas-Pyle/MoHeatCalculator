import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MoHeatCalculator extends JFrame {
	private String[] buttonNames = {"Heat Transfer","Mass Transfer","Steady State","Un Steady State","Go Back"};
	private String[] textFeildNames;
	private String[] windowNames = {"Start menue","Heat Transfer","MassTransfer"};
	private ButtonController[] buttons = new ButtonController[buttonNames.length];
	private JFrame[] windows = new JFrame[3] ;
	private MoHeatCalculator calc;
	private int currentWindow;
	/*rangOfButtonOnWindow is also an index: first window has 2 buttons second window has 2 buttons for the second index of range 
	we must add the previous number of buttons to it {n,n+buttons on fram 2,n +buttons on frame 3} and so on*/
	private int[] rangeOfButtonsOnWindow = {2,4,5};
	public void GuiInitilizer() {
		
		
		/**********************************************************************************************
		 * this is Initlization for the array containning every window
		 */
		for (int i = 0; i < windows.length; ++i) {
			windows[i] = new JFrame();
			windows[i].setSize(400,400);
			windows[i].setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			windows[i].setLayout(null);
		}
		/**********************************************************************************************
		 * this is Initilazation for the Start menue it adds buttons and labels accordingly
		 */
		for(int i = 0; i < rangeOfButtonsOnWindow[0]; ++i) {
			int xpos = 130;
			int ypos = 40;
			int widith = 100;
			int height = 50;
			buttons[i] = new ButtonController(xpos,ypos + 60 * i,widith,height,buttonNames[i],calc);
			windows[0].add(buttons[i].getButton());
		}
		/********************************************************************************************
		 * this is Initiliazation for the Heat Transfer Window it adds buttons and labels accordingly
		 */
		/*for (int i = rangeOfButtonsOnWindow[0]; i < rangeOfButtonsOnWindow[1]; ++i) {
			int xpos = 130;
			int ypos = 40;
			int widith = 100;
			int height = 50;
			buttons[i] = new ButtonController(xpos,ypos + 60 * i,widith,height,buttonNames[i],calc);
			windows[1].add(buttons[i].getButton());
		}*/
		buttonInitilizer(130,40,60,60,100,50,"Heat Transfer","Start menue",1,2);
		
		
		/******************************************************************************************
		 * this is initiliazation for the Mass Transfer Window it adds buttons and labels accordingly
		 */
		
		for (int i = rangeOfButtonsOnWindow[1]; i <rangeOfButtonsOnWindow[2]; ++i) {
			buttons[i] = new ButtonController(130, 40, 100, 50, "back", calc);
			windows[2].add(buttons[i].getButton());
		}
		JLabel lable = new JLabel("This feature is comming soon");
		lable.setBounds(100, 200, 200, 40);
		windows[2].add(lable);
		
		
		
		/*********************************************************************************************
		 * this sets up the SteadState heatTransferWindow
		 */
		
		
		windows[0].setVisible(true);
		currentWindow = 0;
		
		
	}
	
	public static void main(String [] args) {
		MoHeatCalculator cal = new MoHeatCalculator();
		cal.setCalculatorObject(cal);
		cal.GuiInitilizer();
		
		
	}public JFrame[] getwindowArray() {
		return windows;
	}private void setCalculatorObject(MoHeatCalculator calc) {
		this.calc = calc;
	}public int getCurrentWindow() {
		return currentWindow;
	}public void setCurrentWindwo(int currentWindow) {
		this.currentWindow = currentWindow;
	}private void buttonInitilizer(int xIni,int yIni, int xSpacing,int ySpacing,int height,int widith ,String windowName,String perviousWindow,int rows,int columns) {
		int desieredWindow = -1;
		int oldWindow = -1;
		for (int i = 0; i < windowNames.length; ++i) {
			if (perviousWindow.equals(windowNames[i])) {
				oldWindow = i;
			}else if (windowName.equals(windowNames[i])) {
				desieredWindow = i;
				
			}
			
		}
		
		int currentColumn = 1 ,currentRow = 1, xpos = xIni, ypos = yIni;
		for (int i = rangeOfButtonsOnWindow[oldWindow], k = 0; i < rangeOfButtonsOnWindow[desieredWindow]; ++i , ++k) {
			buttons[i] = new ButtonController(xpos,ypos,widith,height,buttonNames[i],calc);
			windows[desieredWindow].add(buttons[i].getButton());
			if (currentColumn != columns) {
				xpos = xSpacing * k + xIni;
			}else if (currentRow != rows) {
				ypos = ySpacing * k + yIni;
				columns = 1;
			}
		}
	}

	
}
