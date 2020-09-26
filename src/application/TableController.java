package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;

public class TableController {
	
	//RELATIONS
	private EmployeeController employeeControl;
	
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


	public TableController(EmployeeController employeeController) {
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
	
}