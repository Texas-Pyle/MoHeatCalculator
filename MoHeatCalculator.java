import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MoHeatCalculator  extends Application {
	
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
		ScreensController sc = new ScreensController();
		sc.loadScreen("Main Menue", new MainMenue());
		sc.loadScreen("Steady State", new SteadyStateScrene());
		
		sc.setScreen("Main Menue");
		
		StackPane rootPane = new StackPane();
		
		HashMap<String, GridPane> groop = sc.getAll();
		Scene scene = new Scene(rootPane);
		for (String name : groop.keySet()) {
			rootPane.getChildren().add(groop.get(name));
		}
		
		
		
		arg0.setScene(scene);
		arg0.show();
		
		

	}
	
}