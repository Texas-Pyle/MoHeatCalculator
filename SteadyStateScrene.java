import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class SteadyStateScrene implements Loader{
	ScreensController myController;
	
	GridPane pane;
	RadioButton  walls;
	RadioButton  cylinders;
	RadioButton  spheres;
	
	ToggleGroup typeOfMaterial;
	
	Button addMaterial;
	Button removeMaterial;
	Button CalculateHeatTransfer;
	

	@Override
	public void loadUp() {
		initilizeBoxes();
		initilizeButtons();
		initilizeFrame();
		
	}

	private void initilizeFrame() {
		pane = new GridPane();
		pane.setVgap(10);
		pane.setHgap(10);
		Insets gridPadding = new Insets(10,10,10,10);
		pane.setPadding(gridPadding);
		
		pane.add(walls, 4, 3);
		pane.add(cylinders, 4, 4);
		pane.add(spheres, 4, 5);
		pane.add(addMaterial, 4, 6);
		pane.add(removeMaterial, 4, 7);
		pane.add(CalculateHeatTransfer, 4, 8);
		pane.setOpacity(0.0);
		
	}

	private void initilizeButtons() {
		addMaterial = new Button("add Material");
		removeMaterial = new Button("Remove Material");
		CalculateHeatTransfer = new Button ("CalculateHeatTrasfer");
		
		
		
	}

	private void initilizeBoxes() {
		typeOfMaterial = new ToggleGroup();
		
		walls = new RadioButton("Walls");
		cylinders = new RadioButton ("Cylinders and Pipes");
		spheres = new RadioButton("spheres");
		
		walls.setToggleGroup(typeOfMaterial);
		cylinders.setToggleGroup(typeOfMaterial);
		spheres.setToggleGroup(typeOfMaterial);
		
	}

	@Override
	public GridPane getPane() {
		
		return this.pane;
	}

	@Override
	public void setScreenParent(ScreensController screenParent) {
		// TODO Auto-generated method stub
		
	}
	
	//handels all the action events 
	public void Listener() throws Exception{
		
		
		
		
	}
	
}
