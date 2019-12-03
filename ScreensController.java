import java.beans.EventHandler;
import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class ScreensController implements Loader {
	String currentScreen;
	// holds the screens to be displayed 
	private HashMap<String,Object> screens = new HashMap<>(); 
	
	
	// The screens and puts them in the hasMap.  
	public boolean loadScreen(String name , Object screenObj) {
		try {
			((Loader)screenObj).loadUp();
		screens.put(name, screenObj);
		return true;
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
		
		
		
	}
	// turn one screen on and the current one off
	public boolean setScreen(final String name) {
		if (screens.containsKey(name)) {
			if (currentScreen != null) {
				((Loader) screens.get(currentScreen)).getPane().setOpacity(0.0);
				((Loader) screens.get(name)).getPane().setOpacity(1.0);
				((Loader) screens.get(name)).setScreenParent(this);
			}else {
				((Loader) screens.get(name)).getPane().setOpacity(1.0);
				((Loader) screens.get(name)).setScreenParent(this);
			}
			return true;
		}else 
		return false;
	}
	public boolean unloadScreen (String name) {
			if (screens.remove(name) == null) {
				System.out.println("Screen didn;t exist");
				return false;
			}
			else {
				return true;
			}
		}
	@Override
	public void loadUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public GridPane getPane() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setScreenParent(ScreensController screenParent) {
		// TODO Auto-generated method stub
		
	}
	public HashMap<String, GridPane> getAll() {
		HashMap<String, GridPane> paneList = new HashMap<>();
		for (String name : screens.keySet()) {
			paneList.put(name, ((Loader) screens.get(name)).getPane());
		}
		
		return paneList;
	}
	
}
