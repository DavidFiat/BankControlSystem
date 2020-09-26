package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class QueueViewController {
	
	//RELATIONS
	private PrincipalController principalControl;
	
	//---------------------------------------------------------------------
	@FXML
    private BorderPane panel;
	
	public QueueViewController(PrincipalController principalController) {
		principalControl = principalController;
	}
	
	 @FXML
	 void returnInterface(ActionEvent event) {
		 FXMLLoader fxml = new FXMLLoader(getClass().getResource("PrincipalWindows.fxml"));
		 fxml.setController(principalControl);
		 
		 try {
			Parent root = fxml.load();
			panel.getChildren().clear();
			panel.setCenter(root);
			
			principalControl.enableBtt(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
