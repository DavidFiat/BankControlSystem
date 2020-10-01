package application;

import java.io.IOException;
import java.util.Optional;

import customExceptions.NoEnoughMoneyException;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Client;

public class MenuController {
	
	//RELATIONS
	private TableController tableControl;
	
	//========================================================================0
	
	//MenuOptions.fxml
	@FXML
    private BorderPane panel;
	
	//moneyWindow.fxml
	@FXML
	private Button retireBT;

	@FXML
	private Button consignBT;
	
	@FXML
    private TextField amountTF;
	
	//information.fxml
	@FXML
    private Label customerLb;

    @FXML
    private Label idLB;

    @FXML
    private Label accountLB;

    @FXML
    private Label cardLB;

    @FXML
    private Label amountDebitLB;

    @FXML
    private TextField debtTF;
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
		        
		        showData();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void showData() {
		Client temp = tableControl.searchClient('c');
		
		customerLb.setText(temp.getName());
		idLB.setText(temp.getID());
		accountLB.setText(temp.getAccount());
		
		if (temp.getCard() == 1) {
			cardLB.setText("Credito");
		}else if (temp.getCard() == 2) {
			cardLB.setText("Debito");
		}
		
		amountDebitLB.setText(String.valueOf(temp.getAmount()));
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
	void consign(ActionEvent event) {
		Client temp = tableControl.searchClient('c');
		temp.consign(Double.parseDouble(amountTF.getText()));
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("CONSIGNACION EXITOSA");
		alert.setHeaderText(null);
		alert.setContentText("Se ha realizado una consginacion por " + Double.parseDouble(amountTF.getText()));
		alert.showAndWait();
	}
	 
	@FXML
	void retireAction(ActionEvent event) {
		openMoneyWindow();
		retireBT.setVisible(true);
		consignBT.setVisible(false);
		
	}
	
	@FXML
    void retire(ActionEvent event) {
		try {
			Client aux = tableControl.searchClient('c');
			aux.withdraw(Double.parseDouble(amountTF.getText()));
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("RETIRO EXITOSO");
			alert.setHeaderText(null);
			alert.setContentText("Se ha realizado un retiro de " + Double.parseDouble(amountTF.getText()));
			alert.showAndWait();
		} catch (NoEnoughMoneyException ne) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("DINERO INSUFICIENTE");
			alert.setHeaderText(null);
			alert.setContentText(ne.getMessage());
			alert.showAndWait();
		}
    }
	
	@FXML
    void cancelAction(ActionEvent event) {
		Client temp = tableControl.searchClient('c');
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("WARNING CANCEL");
		alert.setContentText("¿Seguro que quieres cancelar la operacion?");
		alert.initStyle(StageStyle.UTILITY);
		
		Optional<ButtonType>result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			returnInterface(event);
		}
    }

	@FXML
    void undoAction(ActionEvent event) {
		Client temp = tableControl.searchClient('c');
		String operation = temp.visualizeLast().getOperation();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("WARNING UNDO");
		alert.setHeaderText("La ultima operacion que realizó fue: " +  operation);
		alert.setContentText("¿Seguro que quieres deshacer la ultima operacion?");
		alert.initStyle(StageStyle.UTILITY);
		
		Optional<ButtonType>result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			temp.UNDO();
		}
    }
	
	@FXML
    void payCard(ActionEvent event) {
		Client aux = tableControl.searchClient('c');
		try {
			aux.payCreditCard(Double.parseDouble(debtTF.getText()));
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("PAGO");
			alert.setHeaderText(null);
			alert.setContentText("Se ha realizado el pago");
			alert.showAndWait();
		} catch ( NoEnoughMoneyException n) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("DINERO INSUFICIENTE");
			alert.setHeaderText(null);
			alert.setContentText(n.getMessage());
			alert.showAndWait();
		}catch (NumberFormatException e) {
			System.err.println(e.getLocalizedMessage());
		}
    }
	
	@FXML
    void payCash(ActionEvent event) {
		Client aux = tableControl.searchClient('c');
		aux.payCash(Double.parseDouble(debtTF.getText()));
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("PAGO");
		alert.setHeaderText(null);
		alert.setContentText("Se ha realizado el pago");
		alert.showAndWait();
    }
}
