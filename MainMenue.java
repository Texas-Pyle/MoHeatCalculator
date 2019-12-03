import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class MainMenue implements  Loader  {
	ScreensController myController;
	Label Title; 
	Button SteadyStateHeatTransfer;
	Button UnsteadyStateHeatTransfer;
	
	GridPane pane;
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
		
	}
	
	public void loadUp() {
		Title = new Label( "Heat Transfer Calculator");
		Title.setFont(Font.font(50));
		SteadyStateHeatTransfer = new Button("Steady State Heat Transfer");
		UnsteadyStateHeatTransfer = new Button ("Un steady State Heat Transfer");
		
		pane = new GridPane();
		
		
		pane.setVgap(10);
		pane.setHgap(10);
		Insets gdridPadding = new Insets(10,10,10,10);
		pane.setPadding(gdridPadding);
		
		pane.setColumnSpan(Title, 3);
		
		pane.add(Title,0,0);
		pane.add(SteadyStateHeatTransfer, 1,1);
		pane.add(UnsteadyStateHeatTransfer, 2, 1);
		
		MainMenue me = this;
		try {
			me.listener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public GridPane getPane() {
		
		return this.pane;
	}
	public void listener()throws Exception{
		
	UnsteadyStateHeatTransfer.setOnAction(new EventHandler<ActionEvent>() {
		@Override 
		public void handle (ActionEvent event) {
			System.out.println("working");
		}
	});
	
	SteadyStateHeatTransfer.setOnAction(new EventHandler<ActionEvent>() {
		@Override 
		public void handle (ActionEvent event) {
			myController.setScreen("Steady State");
		}
	});
	}
}


	