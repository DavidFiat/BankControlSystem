package application;

import java.io.IOException; 
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Client;

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
    
    ArrayList<Client>listClientsG = new ArrayList<Client>();
    ArrayList<Client>listClientsP = new ArrayList<Client>();
	
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
		 String name = customerTurn.getText();
		 String id = idTurn.getText();
		 int priority = 0;
		 
		 if (priorityBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("General")) {
			priority = 1;
		 }else if (priorityBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("Estado Embarazo")) {
			priority = 4;
		 }else if (priorityBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("Niño en Brazos")) {
			priority = 5;
		 }else if (priorityBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("Discapacitado")) {
			priority = 2;
		 }else {
			priority = 3;
		 }
		 
		 Client cl = new Client(name, id, priority);
		 String queue = "";
		 
		 if (priority == 1) {
			queue = "General";
			principalControl.enqueueBoth(cl, 1);
		 }else {
			queue = "Prioridad";
			principalControl.enqueueBoth(cl, 2);
		}
		 
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("YOUR TURN");
		 alert.setHeaderText(null);
		 alert.setContentText("Has sido asginado a la cola: " + queue);
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
	 
	 public ArrayList<Client> getListClientsG(){
		 return listClientsG;
	 }
	 
	 public ArrayList<Client> getListClientsP(){
		 return listClientsP;
	 }
}
