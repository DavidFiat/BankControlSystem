package application;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class QueueViewController {
	
	//RELATIONS
	private PrincipalController principalControl;
	
	//---------------------------------------------------------------------
	@FXML
    private BorderPane panel;
	
	@FXML
    private ListView<String> generalList;

    @FXML
    private ListView<String> priorityList;
    
    ObservableList<String>list = FXCollections.observableArrayList();
    ObservableList<String>listP = FXCollections.observableArrayList();
	
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
	 
	 public void initializeGeneral() {
		list.clear();
		generalList.getItems().clear();
		
		for (int i = 0; i < principalControl.clientTurnG().size(); i++) {
			list.add(principalControl.clientTurnG().get(i).getID());
		}
		 
		 generalList.getItems().addAll(list);
	 }
	 
	 public void initializePriority() {
		listP.clear();
		priorityList.getItems().clear();
			
		for (int i = 0; i < principalControl.clientTurnP().size(); i++) {
			listP.add(principalControl.clientTurnP().get(i).getID());
		}
			 
		priorityList.getItems().addAll(listP);
	}
	 
	 @FXML
	 void attendGeneral(ActionEvent event) {
		 principalControl.dequeueBoth(1);
	 }

	 @FXML
	 void attendPriority(ActionEvent event) {
		 principalControl.dequeueBoth(2);
	 }
	 
	 @FXML
	 void refresh(ActionEvent event) {
		 initializeGeneral();
		 initializePriority();
	 }
}
