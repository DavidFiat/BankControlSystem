package application;

import java.io.IOException;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Client;

public class TableController {

	// RELATIONS
	private MenuController menuControl;

	private PrincipalController principalControl;

	private Client cl;

	// ----------------------------------------------------
	@FXML
	private BorderPane panel;

	@FXML
	private TableView<Client> tableCustomer;

	@FXML
	private TableColumn<Client, String> nameView;

	@FXML
	private TableColumn<Client, String> idView;

	@FXML
	private TableColumn<Client, String> timeView;

	@FXML
	private TableColumn<Client, String> amountView;
	
	//=====================================================
	
	//register.fxml
	@FXML
    private TextField customerTF;

    @FXML
    private TextField idTF;

    @FXML
    private TextField accountTF;

    @FXML
    private RadioButton debitBox;

    @FXML
    private RadioButton creditBox;

    //==================================================================
    
	public TableController(PrincipalController principalController) {
		menuControl = new MenuController(this);
		principalControl = principalController;
	}

	public void initialize(List<Client> list) {

		tableCustomer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Client>() {

			@Override
			public void changed(ObservableValue<? extends Client> observable, Client oldValue, Client newValue) {
				cl = tableCustomer.getSelectionModel().getSelectedItem();
				System.out.println(cl.getName());
			}

		});
		ObservableList<Client> listClient = FXCollections.observableArrayList(list);


		nameView.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		idView.setCellValueFactory(new PropertyValueFactory<Client, String>("ID"));
		timeView.setCellValueFactory(new PropertyValueFactory<Client, String>("year"));
		amountView.setCellValueFactory(new PropertyValueFactory<Client, String>("amount"));
		tableCustomer.setItems(listClient);
	}
	
	public Client searchClient(char status) {
		return principalControl.searchClient(cl.getID(), status);
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
		initialize(principalControl.list(2));
	}

	@FXML
	void nameView(ActionEvent event) {
		
	}

	@FXML
	void timeView(ActionEvent event) {

	}

	@FXML
	void OpenRegister(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Register.fxml"));
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
	
	@FXML
    void register(ActionEvent event) {
		String name = customerTF.getText();
		String id = idTF.getText();
		String account = accountTF.getText();
		int card = 0;
		
		if (debitBox.isSelected()) {
			card = 2;
		}
		if (creditBox.isSelected()) {
			card = 1;
		}
		
		Client c = new Client(name, id, account, card, -1);
		
		principalControl.addClient(c);
		
		customerTF.setText("");
		idTF.setText("");
		accountTF.setText("");
    }

}