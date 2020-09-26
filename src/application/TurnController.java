package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

public class TurnController {

	//RELATIONS
	private PrincipalController principalControl;
	
	@FXML
    private TextField customerTurn;

    @FXML
    private TextField idTurn;	
	
	public TurnController(PrincipalController principalController) {
		principalControl = principalController;
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

}
