package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	PrincipalController controller;
	
	public Main() {
		controller = new PrincipalController();
	}
	@Override
	public void start(Stage primaryStage) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("PrincipalWIndows.fxml"));
		fxml.setController(controller);
		
		try {
			Parent root = fxml.load();
			Scene sc = new Scene(root);
			primaryStage.setScene(sc);
			primaryStage.show();
			
			controller.progressStart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
