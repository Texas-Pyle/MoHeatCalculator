import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
import javafx.stage.Popup;

public class SteadyStateScrene implements Loader{
	ArrayList<Material> materials = new ArrayList<Material>();
	
	ScreensController myController;
	ColumnConstraints colum1,colum2,colum3;
	RowConstraints row1, row2, row3,row4,row5,row6,row7,row8,row9,row10,row11;
	GridPane pane;
	RadioButton  walls;
	RadioButton  cylinders;
	RadioButton  spheres;
	
	ToggleGroup typeOfMaterial;
	
	Button addMaterial;
	Button removeMaterial;
	Button CalculateHeatTransfer;
	
	
	Pane drawingBoard;
	
	TextField height;//will not be used in spherical or cylindrical
	TextField length;
	TextField depth;// will be used as diameter for cylindrical and spherical
	TextField heatTransferCoefficient;
	
	Label heightLabel;
	Label lengthlabel; 
	Label depthLabel;
	Label heatTransferCoefficientLabel;
	
	
	
	

	@Override
	public void loadUp() {
		initilizeBoxes();
		initilizeButtons();
		initilizeTextField();
		
		initilizDrawingBoard();
		initilizeFrame();
		
		
		SteadyStateScrene st = this;
		try {
			st.listener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	private void initilizeTextField() {
		height = new TextField();
		length = new TextField();
		depth = new TextField();
		heatTransferCoefficient = new TextField();
		heightLabel = new Label("height");
		lengthlabel = new Label("Lenght");
		depthLabel = new Label("Depth");
		clearTextFields();
		heatTransferCoefficientLabel = new Label("K");
		
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
		colum3 = new ColumnConstraints();
		colum1.setPercentWidth(80);
		colum2.setPercentWidth(10);
		colum3.setPercentWidth(10);
		pane.getColumnConstraints().addAll(colum1,colum2,colum3);
		
		row1 = new RowConstraints();
		row2 = new RowConstraints();
		row3 = new RowConstraints();
		row4 = new RowConstraints();
		row5 = new RowConstraints();
		row6 = new RowConstraints();
		row7 = new RowConstraints();
		row8 = new RowConstraints();
		row9 = new RowConstraints();
		row10 = new RowConstraints();
		row11 = new RowConstraints();
		
		row1.setPercentHeight(5);
		row2.setPercentHeight(5);
		row3.setPercentHeight(5);
		row4.setPercentHeight(5);
		row5.setPercentHeight(5);
		row6.setPercentHeight(5);
		row7.setPercentHeight(5);
		row8.setPercentHeight(5);
		row9.setPercentHeight(5);
		row10.setPercentHeight(5);
		row11.setPercentHeight(50);
		
		pane.getRowConstraints().addAll(row1,row2,row3,row4,row5,row6,row7,row8,row9,row10,row11);
		
		
		
		pane.setColumnSpan(drawingBoard, 1);
		pane.setRowSpan(drawingBoard, 11);
		
		pane.add(walls, 1, 0);
		pane.add(cylinders, 1, 1);
		pane.add(spheres, 1, 2);
		pane.add(addMaterial, 1, 3);
		pane.add(removeMaterial, 1, 4);
		pane.add(CalculateHeatTransfer, 1, 5);
		pane.add(heightLabel, 1, 6);
		pane.add(height, 2, 6);
		pane.add(lengthlabel, 1, 7);
		pane.add(length, 2, 7);
		pane.add(depthLabel, 1	, 8);
		pane.add(depth, 2, 8);
		pane.add(heatTransferCoefficientLabel, 1, 9);
		pane.add(heatTransferCoefficient, 2, 9);
		pane.add(drawingBoard, 0, 0);
		pane.setVisible(false);
		
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
		walls.setSelected(true);
		
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
	public void listener() throws Exception{
		walls.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				heightLabel.setVisible(true);
				height.setEditable(true);
				lengthlabel.setVisible(true);
				length.setEditable(true);
				depthLabel.setText("depth");
				clearTextFields();
				
			}
		});
		spheres.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				heightLabel.setVisible(false);
				height.setEditable(false);
				lengthlabel.setVisible(false);
				length.setEditable(false);
				depthLabel.setText("Diamater");
				clearTextFields();
				
			}
		});
		cylinders.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				heightLabel.setVisible(false);
				height.setEditable(false);
				lengthlabel.setVisible(true);
				length.setEditable(true);
				
				depthLabel.setText("Diamater");
				clearTextFields();
				
				
			}
		});
		addMaterial.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			if (walls.isSelected()) {
				double k = Double.parseDouble(heatTransferCoefficient.getText());
				double lengthInt = Double.parseDouble(length.getText());
				double heightNum = Double.parseDouble(height.getText());
				double depthNum = Double.parseDouble(depth.getText());
				materials.add(new Material("cartesian",k,lengthInt,heightNum,depthNum));
			}else if (spheres.isSelected()) {
				//TODO:
			}else {
				//TODO creat new material for cylinder 
			}
			}
		});
		removeMaterial.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		CalculateHeatTransfer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void clearTextFields(){
		height.setText("0.0");
		length.setText("0.0");
		depth.setText("0.0");
		heatTransferCoefficient.setText("0.0");
	}
	private void clearMaterial() {
		materials = new ArrayList();
			
	}
	
}
