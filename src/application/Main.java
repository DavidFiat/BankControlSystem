package application;
	
<<<<<<< HEAD
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
=======
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
>>>>>>> master
import javafx.fxml.FXMLLoader;


public class Main extends Application {
<<<<<<< HEAD
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
=======
	
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
>>>>>>> master
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
