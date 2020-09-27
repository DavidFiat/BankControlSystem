package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MenuController {
	
	//RELATIONS
	private TableController tableControl;
	
	//---------------------------------------------------------------------
	@FXML
    private BorderPane panel;
	
	public MenuController(TableController tableController) {
		tableControl = tableController;
	}

	 @FXML
	 void returnInterface(ActionEvent event) {
		 FXMLLoader fxml = new FXMLLoader(getClass().getResource("SpreadSheet.fxml"));
		 fxml.setController(tableControl);
		 
		 try {
			Parent root = fxml.load();
			panel.getChildren().clear();
			panel.setCenter(root);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	
	 
	 
}
