package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datastructure.Heap;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private PrincipalController controller;

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
			primaryStage.setResizable(false);
			primaryStage.show();

			controller.progressStart();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		launch(args);
//
//		List<String> l = new ArrayList<String>();
//		l.add("1");
//		l.add("6");
//		l.add("2");
//		l.add("8");
//		l.add("12");
//		l.add("13");
//		l.add("1");
//		l.add("46");
//		l.add("10");
//		l.add("123");
//
//		Heap.heapSort(l);
//		System.out.println(l);

	}

}
