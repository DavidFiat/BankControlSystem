package application;

import java.io.IOException;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {
	
	//RELATIONS
	private TableController tableControl;
	
	//========================================================================0
	
	//MenuOptions.fxml
	@FXML
    private BorderPane panel;
	
	//moneWindow.fxml
	@FXML
	private Button retireBT;

	@FXML
	private Button consignBT;
	
	//information.fxml
	@FXML
    private Label customerLb;

    @FXML
    private Label idLB;

    @FXML
    private Label accountLB;

    @FXML
    private Label accountLB1;

    @FXML
    private Label amountDebitLB;

    @FXML
    private Label amountCreditLB;
    
    //=========================================================================
	
	public MenuController(TableController tableController) {
		tableControl = tableController;
	}

	@FXML
	void returnInterface(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("SpreadSheet.fxml"));
		fxml.setController(tableControl);
		 
		try {
			Parent root = fxml.load();
			panel.getChildren().clear();
			panel.setCenter(root);
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	@FXML
	void payAction(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("PayWindow.fxml"));
		fxml.setController(this);
		 
		try {
				Parent root = fxml.load();
				Stage stage = new Stage();
				Scene scene = new Scene(root);
		        stage.initModality(Modality.APPLICATION_MODAL);
		        stage.initStyle(StageStyle.DECORATED);
		        stage.setTitle("PAGO DEUDA");
		        stage.setResizable(true);
		        stage.setScene(scene);
		        stage.show();
		        
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	 
	@FXML
	void viewData(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Information.fxml"));
		fxml.setController(this);
		 
		try {
				Parent root = fxml.load();
				Stage stage = new Stage();
				Scene scene = new Scene(root);
		        stage.initModality(Modality.APPLICATION_MODAL);
		        stage.initStyle(StageStyle.DECORATED);
		        stage.setTitle("INFORMACION CLIENTE");
		        stage.setResizable(true);
		        stage.setScene(scene);
		        stage.show();
		        
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	void openMoneyWindow() {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("moneyWindow.fxml"));
		fxml.setController(this);
		 
		try {
				Parent root = fxml.load();
				Stage stage = new Stage();
				Scene scene = new Scene(root);
		        stage.initModality(Modality.APPLICATION_MODAL);
		        stage.initStyle(StageStyle.DECORATED);
		        stage.setTitle("MANEJO DINERO CLIENTE");
		        stage.setResizable(true);
		        stage.setScene(scene);
		        stage.show();
		        
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@FXML
	void consignAction(ActionEvent event) {
		openMoneyWindow();
		consignBT.setVisible(true);
		retireBT.setVisible(false);
	}
	 
	@FXML
	void retireAction(ActionEvent event) {
		openMoneyWindow();
		retireBT.setVisible(true);
		consignBT.setVisible(false);
	}
	
	@FXML
    void cancelAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("WARNING CANCEL");
		alert.setHeaderText(null);
		alert.setContentText("¿Seguro que quieres cancelar la operacion?");
		alert.initStyle(StageStyle.UTILITY);
		
		Optional<ButtonType>result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			//metodo cancelar
		}
    }

	@FXML
    void undoAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("WARNING UNDO");
		alert.setHeaderText("La ultima operacion que realizó fue: ");
		alert.setContentText("¿Seguro que quieres deshacer la ultima operacion?");
		alert.initStyle(StageStyle.UTILITY);
		
		Optional<ButtonType>result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			//metodo cancelar
		}
    }
}
