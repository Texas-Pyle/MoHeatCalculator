import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class SteadyStateScrene implements Loader{
	ScreensController myController;
	ColumnConstraints colum1,colum2;
	RowConstraints row1, row2, row3,row4,row5,row6,row7,row8;
	GridPane pane;
	RadioButton  walls;
	RadioButton  cylinders;
	RadioButton  spheres;
	
	ToggleGroup typeOfMaterial;
	
	Button addMaterial;
	Button removeMaterial;
	Button CalculateHeatTransfer;
	
	Pane drawingBoard;

	@Override
	public void loadUp() {
		initilizeBoxes();
		initilizeButtons();
		initilizDrawingBoard();
		initilizeFrame();
		
		SteadyStateScrene st = this;
		try {
			st.Listener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void initilizDrawingBoard() {
		drawingBoard = new Pane();
		drawingBoard.setMaxSize(10000, 10000);
		drawingBoard.setMinSize(100, 100);
		
		drawingBoard.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
	            new BorderWidths(1))));
		
	}

	private void initilizeFrame() {
		pane = new GridPane();
		pane.setVgap(10);
		pane.setHgap(10);
		Insets gridPadding = new Insets(10,10,10,10);
		pane.setPadding(gridPadding);
		
		colum1 = new ColumnConstraints();
		colum2 = new ColumnConstraints();
		colum1.setPercentWidth(80);
		colum2.setPercentWidth(20);
		pane.getColumnConstraints().addAll(colum1,colum2);
		
		row1 = new RowConstraints();
		row2 = new RowConstraints();
		row3 = new RowConstraints();
		row4 = new RowConstraints();
		row5 = new RowConstraints();
		row6 = new RowConstraints();
		row7 = new RowConstraints();
		row8 = new RowConstraints();
		
		row1.setPercentHeight(5);
		row2.setPercentHeight(5);
		row3.setPercentHeight(5);
		row4.setPercentHeight(5);
		row5.setPercentHeight(5);
		row6.setPercentHeight(5);
		row7.setPercentHeight(70);
		//row8.setPercentHeight(5);
		
		pane.getRowConstraints().addAll(row1,row2,row3,row4,row5,row6,row7);
		
		
		
		pane.setColumnSpan(drawingBoard, 1);
		pane.setRowSpan(drawingBoard, 7);
		
		pane.add(walls, 1, 0);
		pane.add(cylinders, 1, 1);
		pane.add(spheres, 1, 2);
		pane.add(addMaterial, 1, 3);
		pane.add(removeMaterial, 1, 4);
		pane.add(CalculateHeatTransfer, 1, 5);
		pane.add(drawingBoard, 0, 0);
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
