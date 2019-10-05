import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;

public class MoHeatCalculator extends JFrame {
	private String[] buttonNames = {"Heat Transfer","Mass Transfer","Steady State","Un Steady State","Go Back"};
	private String[] textFeildNames;
	private String[] windowNames = {"Start menue","Heat Transfer","Mass Transfer"};
	private ButtonController[] buttons = new ButtonController[buttonNames.length];
	private JFrame[] windows = new JFrame[3] ;
	private MoHeatCalculator calc;
	private int currentWindow;
	private ArrayList<int[]> buttonRange = new ArrayList<int[]>();
	
	public void GuiInitilizer() {
		
		
		for (int i = 0; i < windows.length; ++i) {
			windows[i] = new JFrame();
			windows[i].setSize(400,400);
			windows[i].setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			windows[i].setLayout(null);
		}
		
		//Start menue frame
		//x,y,x spacing,y"",height,widith, desiered frame , previous frame , rows, columns
		buttonInitilizer(100,150,60,60,50,150,"Start menue",2,1);
		
		
		
		//heat trasfer Frame
		buttonInitilizer(100,150,60,60,50,150,"Heat Transfer",2,1);
		
		
		
		//mass transfer frame
		buttonInitilizer(100,150,60,60,50,150,"Mass Transfer",1,1);
		JLabel lable = new JLabel("This feature is comming soon");
		lable.setBounds(100, 200, 200, 40);
		windows[2].add(lable);
		
		
		windows[0].setVisible(true);
		currentWindow = 0;
		
		
	}
	
	public static void main(String [] args) throws IOException {
		MoHeatCalculator cal = new MoHeatCalculator();
		cal.setCalculatorObject(cal);
		cal.InitilizebuttonRange(); 
		cal.GuiInitilizer();
		
		 
	}public JFrame[] getwindowArray() {
		return windows;
	}
	private void setCalculatorObject(MoHeatCalculator calc) {
		this.calc = calc;
	}
	public int getCurrentWindow() {
		return currentWindow;
	}
	public void setCurrentWindwo(int currentWindow) {
		this.currentWindow = currentWindow;
	}
	private void buttonInitilizer(int xIni,int yIni, int xSpacing,int ySpacing,int height,int widith ,String windowName,int rows,int columns) {
		int desieredWindow = -1;
		int oldWindow = -1;
		for (int i = 0; i < windowNames.length; ++i) {
			 if (windowName.equals(windowNames[i])) {
				desieredWindow = i;
				
			}
			
		}
		
		int currentColumn = 1 ,currentRow = 1, xpos = xIni, ypos = yIni;
		int[] buttonRange = this.buttonRange.get(desieredWindow);
		for (int i = buttonRange[0], k = 1; i < buttonRange[1]; ++i , ++k) {
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
	private void InitilizebuttonRange() throws IOException {
		final String fileName = "button Range.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		// first Line doesnt contain data
		br.readLine();
		String lineData = br.readLine();
		while(lineData != null) {
			String[] splitData = lineData.split(",");
			int[] range = {Integer.parseInt(splitData[0]),Integer.parseInt(splitData[1])};
			buttonRange.add(range);
			lineData = br.readLine();
		}
	}
	
}
