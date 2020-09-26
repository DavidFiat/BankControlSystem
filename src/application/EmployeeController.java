package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class EmployeeController {
	
	//Relations
	private TableController tableControl;
	
	private PrincipalController principalControl;
	
	private MenuController menuControl;
	
	//---------------------------------------------------------
	@FXML
    private BorderPane mainPanel;
	
	@FXML
    private Button returmBt;
	
	
	public EmployeeController(PrincipalController principalController) {
		tableControl = new TableController(this);
		principalControl = principalController;
		menuControl = new MenuController(this);
	}
	
	@FXML
    void showOptions(ActionEvent event) {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("Employee.fxml"));
    	fxml.setController(menuControl);
    	
    	try {
			Parent root = fxml.load();
			mainPanel.getChildren().clear();
			mainPanel.setCenter(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	 @FXML
	 void showTable(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("SpreadSheet.fxml"));
	    fxml.setController(tableControl);
	    	
	    try {
			Parent root = fxml.load();
			mainPanel.getChildren().clear();
			mainPanel.setCenter(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @FXML
	 void returnInterface(ActionEvent event) {
		 FXMLLoader fxml = new FXMLLoader(getClass().getResource("PrincipalWindows.fxml"));
		 fxml.setController(principalControl);
		 
		 try {
			Parent root = fxml.load();
			mainPanel.getChildren().clear();
			mainPanel.setCenter(root);
			
			principalControl.enableBtt(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
}
