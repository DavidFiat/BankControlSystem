package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {
	
	//RELATIONS
	private EmployeeController employeeControl;
	
	//---------------------------------------------------------------------
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
	 
	 @FXML
	 void OpenRegister(ActionEvent event) {
		 FXMLLoader fxml = new FXMLLoader(getClass().getResource("Register2.fxml"));
		 fxml.setController(this);
		 
		 try {
				Parent root = fxml.load();
				Stage stage = new Stage();
				Scene scene = new Scene(root);
		        stage.initModality(Modality.APPLICATION_MODAL);
		        stage.initStyle(StageStyle.DECORATED);
		        stage.setTitle("REGISTRAR CLIENTE");
		        stage.setResizable(true);
		        stage.setScene(scene);
		        stage.show();
		        
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
	 }
	 
	 
}
