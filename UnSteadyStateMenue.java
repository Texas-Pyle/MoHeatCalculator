import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class UnSteadyStateMenue implements Loader{
	ScreensController myController;
	
	Label Title;
	Button goBack;
	GridPane pane;
	
	@Override
	public void loadUp() {
		Title = new Label("This Feature is comming Soon");
		Title.setFont(Font.font(50));
		goBack = new Button ("Main Menue");
		pane = new GridPane();
		
		pane.setVgap(10);
		pane.setHgap(10);
		Insets gdridPadding = new Insets(10,10,10,10);
		pane.setPadding(gdridPadding);
		
		pane.setColumnSpan(Title, 2);
		
		pane.add(Title, 0, 0);
		pane.add(goBack, 1, 1);
		
	}

	@Override
	public GridPane getPane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScreenParent(ScreensController screenParent) {
		this.myController = screenParent;
		
	}

}
