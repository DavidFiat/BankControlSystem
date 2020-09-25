package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class TableController {
	
	@FXML
    private TableColumn<String, String> nameView;

    @FXML
    private TableColumn<String, String> idView;

    @FXML
    private TableColumn<String, String> timeView;

    @FXML
    private TableColumn<String, Integer> amountView;


	public TableController() {
		// TODO Auto-generated constructor stub
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