package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TableController {
	
	//RELATIONS
	private MenuController menuControl;
	
	private PrincipalController principalControl;
	
	//----------------------------------------------------
	@FXML
    private BorderPane panel;
	
	@FXML
    private TableColumn<String, String> nameView;

    @FXML
    private TableColumn<String, String> idView;

    @FXML
    private TableColumn<String, String> timeView;

    @FXML
    private TableColumn<String, Integer> amountView;


	public TableController(PrincipalController principalController) {
		menuControl = new MenuController(this);
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
	 
	 @FXML
	    void showOptions(ActionEvent event) {
	    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("Employee.fxml"));
	    	fxml.setController(menuControl);
	    	
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
    void amountView(ActionEvent event) {

    }
	
	@FXML
	void idView(ActionEvent event) {

	}

	@FXML
	void nameView(ActionEvent event) {

	}
	
	@FXML
    void timeView(ActionEvent event) {

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