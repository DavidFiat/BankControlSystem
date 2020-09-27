package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

public class TurnController{
	//RELATIONS
	private PrincipalController principalControl;
	
	@FXML
	private BorderPane mainPanel;
	
	@FXML
    private TextField customerTurn;

    @FXML
    private TextField idTurn;	
    
    @FXML
    private ComboBox<String> priorityBox;
	
	public TurnController(PrincipalController principalController) {
		principalControl = principalController;
	}
	
	void initializeCombo() {
		priorityBox.getItems().add("General");
		priorityBox.getItems().add("Estado Embarazo");
		priorityBox.getItems().add("Niño en Brazos");
		priorityBox.getItems().add("Adulto Mayor");
		priorityBox.getItems().add("Discapacitado");
	}
	 @FXML
	 void turn(ActionEvent event) {
		 Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Your turn");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Your turn is");
	    	alert.initStyle(StageStyle.UTILITY);
	    	alert.showAndWait();
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
