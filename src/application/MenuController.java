package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MenuController {
	
	//relations
	private EmployeeController employeeControl;
	@FXML
    private BorderPane panel;
	
	public MenuController(EmployeeController employeeController) {
		employeeControl = employeeController;
	}

	 @FXML
	 void returnInterface(ActionEvent event) {
		 FXMLLoader fxml = new FXMLLoader(getClass().getResource("LittleWindow.fxml"));
		 fxml.setController(employeeControl);
		 
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
