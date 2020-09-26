package application;

import java.io.IOException;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

public class PrincipalController {
	
	//RELATIONS
	
	private EmployeeController employeeControl;

	private TurnController turnControl; 
	//-----------------------------------------------------------------
    @FXML
    private BorderPane mainPanel;
	
	@FXML
    private Button employeeBtt;

    @FXML
    private Button customerBtt;

    @FXML
    private ProgressBar progressBar;
    

    @FXML
    private ProgressIndicator progressIndicator;
    
    //-----------------------------------------------------------------------
    
    final Service<Integer> loading = new Service<Integer>() {

		@Override
		protected Task<Integer> createTask() {
			return new Task<Integer>() {

				@Override
				protected Integer call() throws Exception {
					int i;
				
					for (i = 0; i < 1000; i++) {
						updateProgress(i, 1000);
						Thread.sleep(5);
					}
					enableBtt(true);
					return i;
				}
			};
		}
    	
    };
  //-----------------------------------------------------------------------
    public PrincipalController() {
		employeeControl = new EmployeeController(this);
		turnControl = new TurnController(this);
	}
    
    @FXML
    void employeeWindow(ActionEvent event) {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("LittleWIndow.fxml"));
    	fxml.setController(employeeControl);
    	
    	try {
			Parent root = fxml.load();
			mainPanel.getChildren().clear();
			mainPanel.setCenter(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    void progressStart() {
    	progressBar.progressProperty().bind(loading.progressProperty());
    	progressIndicator.progressProperty().bind(loading.progressProperty());
    	
    	loading.start();
    }
    
    void enableBtt(boolean value) {
    	employeeBtt.setDisable(!value);
    	customerBtt.setDisable(!value);
    }
    
    @FXML
    void showTurn(ActionEvent event)  {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("TurnWindow.fxml"));
    	fxml.setController(turnControl);
    	
    	try {
			Parent root = fxml.load();
			mainPanel.getChildren().clear();
			mainPanel.setCenter(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
       
    
}
