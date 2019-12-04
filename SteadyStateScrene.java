
import java.util.ArrayList;

import javax.swing.plaf.PopupMenuUI;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.scene.input.MouseEvent;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class SteadyStateScrene implements Loader{
	ArrayList<Material> materials = new ArrayList<Material>();
	
	ScreensController myController;
	ColumnConstraints colum1,colum2,colum3;
	RowConstraints row1, row2, row3,row4,row5,row6,row7,row8,row9,row10,row11,row12,row13,row14;
	GridPane pane;
	RadioButton  walls;
	RadioButton  cylinders;
	RadioButton  spheres;
	RadioButton includeConvection;
	RadioButton showWork;
	
	ToggleGroup typeOfMaterial;
	
	Button addMaterial;
	Button removeMaterial;
	Button CalculateHeatTransfer;
	Button popUpOk,popUpBack;
	Button parrell;
	
	
	//Pane drawingBoard;  dont have engout time to get to work 
	
	TextField height;//will not be used in spherical or cylindrical
	TextField length;
	TextField depth;// will be used as diameter for cylindrical and spherical
	TextField heatTransferCoefficient;
	TextField tempInfinity;
	TextField temp0;
	TextField popUpHeightText, popUpLengthText , popUpNumberOfMaterials, distanceInBetween , popUpXcordinate,popUpK;
	TextField convectiveTransferCoeficient;
	
	Label heightLabel;
	Label lengthlabel; 
	Label depthLabel;
	Label heatTransferCoefficientLabel;
	Label tempInfinityLabel;
	Label temp0Label;
	Label popupLength;
	Label popupHeight, popupNumberofMaterialsLabel, distanceInBetweenLabel, xCordinatelabel,popUpKLabel;
	Label convenctionTrasferCoeficientLabel;
	
	TextArea textArea ;
	
	GridPane parallelMaterial;
	
	double initialMaterialx;
	double initialMaterialy;
	
	boolean isAdding = false;
	boolean usedConvction = false;
	
	// for the popup 
	Stage popup;
	Scene popupScene;

	@Override
	public void loadUp() {
		initilizeBoxes();
		initilizeButtons();
		initilizeTextField();
		//initilizDrawingBoard();
		initilizePopUp();
		initilizeTextArea();
		initilizeFrame();
		
		
		SteadyStateScrene st = this;
		try {
			st.listener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	private void initilizePopUp() {
		parallelMaterial = new GridPane();
		popupHeight = new Label("height");
		popupLength = new Label ("length");
		popupNumberofMaterialsLabel = new Label ("number of materials");
		distanceInBetweenLabel = new Label ( "distance inbetween materials");
		xCordinatelabel = new Label("distance from origin ft");
		popUpKLabel = new Label("K");
		popUpOk = new Button("add");
		popUpBack = new Button("Back");
		popUpK = new TextField();
		popUpLengthText = new TextField();
		popUpHeightText = new TextField();
		popUpNumberOfMaterials = new TextField();
		popUpNumberOfMaterials.setText("2");
		popUpNumberOfMaterials.setEditable(false);
		distanceInBetween = new TextField();
		popUpXcordinate = new TextField();
		parallelMaterial.add(popupHeight, 1, 1);
		parallelMaterial.add(popUpHeightText, 2, 1);
		parallelMaterial.add(popupLength, 1, 2);
		parallelMaterial.add(popUpLengthText, 2, 2);
		parallelMaterial.add(popUpOk, 1	, 6);
		parallelMaterial.add(popUpBack, 2, 6);
		parallelMaterial.add(popupNumberofMaterialsLabel, 1, 3);
		parallelMaterial.add(popUpNumberOfMaterials, 2, 3);
		parallelMaterial.add(distanceInBetweenLabel, 1, 4);
		parallelMaterial.add(distanceInBetween, 2, 4);
		parallelMaterial.add(xCordinatelabel, 1, 5);
		parallelMaterial.add(popUpXcordinate, 2, 5);
		parallelMaterial.add(popUpKLabel, 1, 0);
		parallelMaterial.add(popUpK, 2, 0);
		
		
		parallelMaterial.setVisible(false);
		parallelMaterial.setVgap(10);
		parallelMaterial.setHgap(10);
		Insets gridPadding = new Insets(10,10,10,10);
		parallelMaterial.setPadding(gridPadding);
		// this must be done here and not in the event listner because a pane can only be added to one scenep; 
		 popupScene = new Scene(parallelMaterial);
	
		
	}


	private void initilizeTextArea() {
		textArea = new TextArea();
		textArea.setFont(new Font(25));
		textArea.setEditable(false);
		
		
	}


	private void initilizeTextField() {
		height = new TextField();
		length = new TextField();
		depth = new TextField();
		tempInfinity = new TextField();
		temp0 = new TextField();
		heatTransferCoefficient = new TextField();
		convectiveTransferCoeficient = new TextField();
		convectiveTransferCoeficient.setEditable(false);
		heightLabel = new Label("height ft");
		lengthlabel = new Label("Lenght ft");
		depthLabel = new Label("Depth ft");
		temp0Label = new Label("temp0 F");
		convenctionTrasferCoeficientLabel = new Label("H");
		tempInfinityLabel = new Label("Temp infinity F");
		clearTextFields();
		heatTransferCoefficientLabel = new Label("K (Btu/h ft F)");
		
		
	}

//	private void initilizDrawingBoard() {
//		drawingBoard = new Pane();
//		drawingBoard.setMaxSize(10000, 10000);
//		drawingBoard.setMinSize(100, 100);
//		
//		drawingBoard.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
//	            new BorderWidths(1))));
//		
//	}

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
		row12 = new RowConstraints();
		row13 = new RowConstraints();
		row14 = new RowConstraints();
		
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
		row11.setPercentHeight(5);
		row12.setPercentHeight(5);
		row13.setPercentHeight(5);
		row14.setPercentHeight(45);
		
		pane.getRowConstraints().addAll(row1,row2,row3,row4,row5,row6,row7,row8,row9,row10,row11,row12,row13,row14);
		
		
		
		pane.setColumnSpan(textArea, 1);
		pane.setRowSpan(textArea, 14);
		
		pane.add(walls, 1, 0);
		pane.add(cylinders, 1, 1);
		pane.add(spheres, 1, 2);
		pane.add(includeConvection,2,0);
		pane.add(showWork, 2, 1);
		pane.add(addMaterial, 1, 3);
		pane.add(parrell, 2, 3);
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
		pane.add(temp0Label, 1, 10);
		pane.add(temp0, 2, 10);
		pane.add(tempInfinityLabel, 1, 11);
		pane.add(tempInfinity, 2, 11);
		pane.add(convenctionTrasferCoeficientLabel, 1, 12);
		pane.add(convectiveTransferCoeficient, 2, 12);
		pane.add(textArea, 0, 0);
		pane.setVisible(false);
		
	}

	private void initilizeButtons() {
		addMaterial = new Button("add Material");
		removeMaterial = new Button("Remove Material");
		CalculateHeatTransfer = new Button ("CalculateHeatTrasfer");
		
		parrell = new Button ("add Parrell material");
	
		
		
		
	}

	private void initilizeBoxes() {
		typeOfMaterial = new ToggleGroup();
		
		walls = new RadioButton("Walls");
		cylinders = new RadioButton ("Cylinders and Pipes");
		spheres = new RadioButton("spheres");
		includeConvection = new RadioButton("include Convection");
		includeConvection.setSelected(false);
		showWork = new RadioButton("Show Work");
		showWork.setSelected(false);
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
				textArea.clear();
				heightLabel.setVisible(true);
				heightLabel.setText("height ft");
				height.setEditable(true);
				lengthlabel.setVisible(true);
				lengthlabel.setText("Length ft");
				length.setEditable(true);
				depthLabel.setText("depth ft");
				parrell.setVisible(true);
				clearTextFields();
				clearMaterial();
				
			}
		});
		spheres.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				textArea.setText("WARNING THIS FEATURE IS NOT COMPLETE AND WILL YEILD A WRONG ANSWER!!!!!");
				heightLabel.setVisible(false);
				height.setEditable(false);
				lengthlabel.setText("Thicknes ft");
				parrell.setVisible(false);
				depthLabel.setText("Diamater ft");
				clearTextFields();
				clearMaterial();
			}
		});
		cylinders.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textArea.clear();
				heightLabel.setText("Inner Diamater");
				lengthlabel.setVisible(true);
				length.setEditable(true);
				lengthlabel.setText("Length ft");
				depthLabel.setText("Diamater ft");
				parrell.setVisible(false);
				clearTextFields();
				clearMaterial();
				
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
				 
			
				if (!includeConvection.isSelected()) {
				materials.add(new Material("conduction",k,lengthInt,heightNum,depthNum));
					textArea.setText(textArea.getText() + String.format("Material %d added with length %.2f depth %.2f and height %.2f with a k of %.2f %n", materials.size() ,lengthInt, heightNum, depthNum, k));
				}
				else {
					materials.add(new Material("convection",Double.parseDouble(convectiveTransferCoeficient.getText()),lengthInt,heightNum,depthNum));
					textArea.setText(textArea.getText() + String.format("Convection was added to the pervious material with a heatTrasferCoeficient of  %.2f", Double.parseDouble(convectiveTransferCoeficient.getText()) ));
				}
				setPosition();
				isAdding = true; 
				
				
			}else if (spheres.isSelected()) {
				//TODO:
				double k = Double.parseDouble(heatTransferCoefficient.getText());
				double diamater = Double.parseDouble(depth.getText());
				double thickness = Double.parseDouble(length.getText());
				if (includeConvection.isSelected()) {
					materials.add(new Material("convection",Double.parseDouble(convectiveTransferCoeficient.getText()),diamater,thickness));
					textArea.setText(textArea.getText() + String.format("Convection was added to the pervious material with a heatTrasferCoeficient of  %.2f", Double.parseDouble(convectiveTransferCoeficient.getText()) ));
				}else {
					materials.add(new Material("conduction",k,diamater,thickness));
					textArea.setText(textArea.getText() + String.format("Material %d added with Outer Diamater of  %.2f Thickness of %.2f with a k of %.2f %n", materials.size(),diamater,thickness	,  k));
				}
				
			}else {
				double k = Double.parseDouble(heatTransferCoefficient.getText());
				double outerDiamater = Double.parseDouble(depth.getText());
				double lengthNum = Double.parseDouble(length.getText());
				double	innerDiamater = Double.parseDouble(height.getText());
				double thickness = outerDiamater - innerDiamater;
				if (includeConvection.isSelected()) {
					materials.add(new Material("convection",Double.parseDouble(convectiveTransferCoeficient.getText()),innerDiamater,thickness,outerDiamater));
					textArea.setText(textArea.getText() + String.format("Convection was added to the pervious material with a heatTrasferCoeficient of  %.2f", Double.parseDouble(convectiveTransferCoeficient.getText()) ));
				}else {
					materials.add(new Material("conduction",Double.parseDouble(heatTransferCoefficient.getText()),innerDiamater,thickness,outerDiamater));
					textArea.setText(textArea.getText() + String.format("Material %d added with Outer Diamater of  %.2f length of %.2f and InnerDiamter of %.2f with a k of %.2f %n", materials.size(),outerDiamater, lengthNum	, innerDiamater, k));
				}
				setPosition();
		
			}
			}
		});
		removeMaterial.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				materials.remove(materials.size() - 1);
				textArea.setText("Material "+ (materials.size() + 1) +" was removed\n");
				
			}
		});
		CalculateHeatTransfer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Material [] mat = new Material[materials.size()];
				for (int i =0 ; i < materials.size(); i++) {
					mat[i] = materials.get(i);
				}
				SteadyStateHeatTransfer st = new SteadyStateHeatTransfer(mat,Double.parseDouble(tempInfinity.getText()), Double.parseDouble(temp0.getText()));
				if (!showWork.isSelected()) {
				textArea.setText("the heat transfer is  "+Double.toString( Math.floor(st.calculateFlux() * 100 )/100) + " Btu/h");
				}else 
				textArea.setText(showWork(st));
				
			}
		});
		parrell.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pane.setVisible(false);
				popup = new Stage();
				
				popup.setScene(popupScene);
				popup.show();
				parallelMaterial.setVisible(true);
				
			}
		});
		popUpOk.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				double heightNum = Double.parseDouble(popUpHeightText.getText());
				double lengthNum = Double.parseDouble(popUpLengthText.getText());
				double distanceBetween = Double.parseDouble(distanceInBetween.getText());
				int numberOfMaterials = Integer.parseInt(popUpNumberOfMaterials.getText());
				double distanceFormOrigion = Double.parseDouble(popUpXcordinate.getText());
				//depth is constant in this case 
				double depth = materials.get(0).getDepth();
				if (numberOfMaterials == 1) {
					materials.add(new Material("conduction", Double.parseDouble(popUpK.getText()), lengthNum, heightNum, depth));
					materials.get(materials.size() - 1).setPosition(new Position(distanceFormOrigion, distanceFormOrigion + lengthNum));
					materials.get(materials.size() - 1).getPosition().setDistanceBetween(distanceBetween);
				}
				
				popup.close();
				pane.setVisible(true);
				textArea.setText(textArea.getText() + String.format("Parallel Material %d added with length %.2f depth %.2f and height %.2f with a k of %.2f %n", materials.size() ,lengthNum, heightNum, depth, Double.parseDouble(heatTransferCoefficient.getText())));
				
			}
		});
		popUpBack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				popup.close();
				pane.setVisible(true);
				
			}
		});
		
		includeConvection.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(includeConvection.isSelected()) {
					convectiveTransferCoeficient.setEditable(true);
					height.setEditable(false);
					length.setEditable(false);
					depth.setEditable(false);
					heatTransferCoefficient.setEditable(false);
					clearTextFields();
				}
				else {
					convectiveTransferCoeficient.setEditable(false);
					height.setEditable(true);
					length.setEditable(true);
					depth.setEditable(true);
					heatTransferCoefficient.setEditable(true);
				}
				
			}
		});
//		drawingBoard.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent mouseEvent) {
//				if(isAdding) {
//				initialMaterialx = mouseEvent.getScreenX();
//				initialMaterialy = mouseEvent.getScreenY();
//				
//				
//				int materalIndex = materials.size();
//				Rectangle rect = new Rectangle(initialMaterialx,initialMaterialy,60*materalIndex,30* materalIndex);
//				rect.setLayoutX(initialMaterialx);
//				rect.setLayoutY(initialMaterialy);
//				rect.setStroke(Color.BLACK);
//				rect.setFill(null);
//				rect.setStrokeWidth(3);
//				drawingBoard.getChildren().add(rect);
//				isAdding = false;
//				}
//			}
//		});
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
	private void setPosition() {
		if (walls.isSelected()) {
		if (materials.size() != 1) {
			double start = materials.get(materials.size()-2).getPosition().getEnd();
			double end = start + materials.get(materials.size() - 1).getLength();
			materials.get(materials.size() - 1).setPosition( new Position(start, end));
			
		}else {
			materials.get(0).setPosition(new Position(0.0, materials.get(0).getLength()));
		}
		}else if (cylinders.isSelected()) {
			if (materials.size() != 1) {
				 double start = materials.get(materials.size()-2).getPosition().getEnd();
				double end = start + (materials.get(materials.size()- 1).getDiameter()/2);
				materials.get(materials.size() - 1).setPosition(new Position(start, end));
			}else {
				materials.get(0).setPosition(new Position(0.0, materials.get(0).getDiameter()/2));
			}
			
		}
	}
	private String showWork(SteadyStateHeatTransfer st) {
		String output = "";
		if (walls.isSelected()) {			
			output = String.format("STEP 1 %n %n calculate the resistance of the material by the formula R = Length/(areal * k) %n if there is convection you will use the Forumla R = 1 / (h * area) "
					+ "%n %n The total resistance comes out to be: %.6f %n%n STEP 2	 %n To find the het transfer q  you use deltaT/R total = %.2f",st.calculateResistance(),st.calculateFlux());
			
		}else if (cylinders.isSelected()) {
			output = String.format("STEP 1 %n %n calculate the resistance of the material by the formula R = ln(Od/Id)/(2 * pi * length* k) %n if there is convection you will use the Forumla R = 1 / (h * area) "
					+ "%n %n The total resistance comes out to be: %.6f %n%n STEP 2	 %n To find the het transfer q  you use deltaT/R total = %.2f",st.calculateResistance(),st.calculateFlux());
		}
		return output;
	}
	
}
