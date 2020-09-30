package application;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

	private Client client;
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
	private TableColumn<Client, Integer> amountView;

	public TableController(PrincipalController principalController) {
		menuControl = new MenuController(this);
		principalControl = principalController;
	}

	public void initialize() {

		tableCustomer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Client>() {

			@Override
			public void changed(ObservableValue<? extends Client> observable, Client oldValue, Client newValue) {
				Client c = tableCustomer.getSelectionModel().getSelectedItem();
				System.out.println(c.getName());
			}

		});

		ObservableList<Client> listClient = FXCollections.observableArrayList();

		ObservableList<Client> listClient = FXCollections.observableArrayList(new Client("Julian", "1000", "1", 2),
				new Client("Andres", "10002", "1", 2));

		nameView.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		idView.setCellValueFactory(new PropertyValueFactory<Client, String>("ID"));
		tableCustomer.setItems(listClient);
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
}