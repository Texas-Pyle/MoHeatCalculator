import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

public class SteadyStateScrene implements Loader{
	ScreensController myController;
	
	GridPane pane;
	CheckBox walls;
	CheckBox cylinders;
	CheckBox spheres;
	
	
	Button addMaterial;
	Button removeMaterial;
	Button CalculateHeatTransfer;
	

	@Override
	public void loadUp() {
		// TODO Auto-generated method stub
		
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
