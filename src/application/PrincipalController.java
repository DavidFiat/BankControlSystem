package application;

import java.io.IOException;
import java.util.List;

import customExceptions.RepeatedElementException;
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
import model.Bank;
import model.Client;

public class PrincipalController {
	
	//RELATIONS
	
	private TableController tableControl;

	private TurnController turnControl; 
	
	private QueueViewController queueControl;
	
	private Bank bank;
	//-----------------------------------------------------------------
    @FXML
    private BorderPane mainPanel;
	
	@FXML
    private Button employeeBtt;

    @FXML
    private Button customerBtt;
    
    @FXML
    private Button queueBT;

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
					enableBtt(false);
					return i;
				}
			};
		}
    	
    };
  //-----------------------------------------------------------------------
    public PrincipalController() {
		tableControl = new TableController(this);
		turnControl = new TurnController(this);
		queueControl = new QueueViewController(this);
		bank = new Bank();
	}
    
    @FXML
    void employeeWindow(ActionEvent event) {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("SpreadSHeet.fxml"));
    	fxml.setController(tableControl);
    	
    	try {
			Parent root = fxml.load();
			mainPanel.getChildren().clear();
			mainPanel.setCenter(root);
			
			//tableControl.prueba();
			
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
    	employeeBtt.setDisable(false);
    	customerBtt.setDisable(false);
    	queueBT.setDisable(false);
    	
    	if (value) {
    		progressBar.setVisible(false);
        	progressIndicator.setVisible(false);
		}
    }
    
    @FXML
    void showTurn(ActionEvent event)  {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("TurnWindow.fxml"));
    	fxml.setController(turnControl);
    	
    	try {
			Parent root = fxml.load();
			mainPanel.getChildren().clear();
			mainPanel.setCenter(root);
			
			turnControl.initializeCombo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
       
    @FXML
    void showQueue(ActionEvent event) {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("QueueWIndow.fxml"));
    	fxml.setController(queueControl);
    	
    	try {
			Parent root = fxml.load();
			mainPanel.getChildren().clear();
			mainPanel.setCenter(root);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    void addClient(Client c) {
    	Alert alert;
    	try {
			bank.addDataBase(c.getID(), c);
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("REGISTERED");
			alert.setHeaderText(null);
			alert.setContentText("El cliente ha sido registrado");
			alert.showAndWait();
		} catch (RepeatedElementException e) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
    }
    
    public List<Client> list(int list){
		List<Client> li = null;
		
		if (list == 1) {
			li = bank.returnClientListByName();
			System.out.println(li.toString());
		}
		if (list == 2) {
			li = bank.returnClientListByID();
		}
		return	 li;
    	
    }
}

